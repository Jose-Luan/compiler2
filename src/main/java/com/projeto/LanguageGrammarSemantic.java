package com.projeto;

public class LanguageGrammarSemantic extends LanguageGrammarBaseVisitor<Object> {
    private LanguageGrammarSemanticUtils semanticUtils;
    private String currentScope;
    private int addressCounter;
    private String currentType;

    public LanguageGrammarSemantic() {
        this.semanticUtils = new LanguageGrammarSemanticUtils();
        this.currentScope = "global";
        this.currentType = "unknown";
        this.addressCounter = 0;
    }

    public SymbolTable getSymbolTable() {
        return semanticUtils.symbolTable;
    }

    @Override
    public Object visitProgram(LanguageGrammarParser.ProgramContext ctx) {
        semanticUtils.enterScope("program");

        for (LanguageGrammarParser.DeclarationContext declaration : ctx.declaration()) {
            visit(declaration);
        }

        for (LanguageGrammarParser.StatementContext statement : ctx.statement()) {
            visit(statement);
        }
        semanticUtils.exitScope();

        return null;
    }

    @Override
    public Object visitVarDeclaration(LanguageGrammarParser.VarDeclarationContext ctx) {
        String identifier = ctx.ID().getText();
        String type = inferTypeFromExpression(ctx.expression());
        int address = addressCounter++;
    
        semanticUtils.validateDeclaration(identifier, type, address, currentScope);
    
        if (ctx.expression() != null) {
            String expressionType = getExpressionType(ctx.expression());
            
            if (!type.equals(expressionType)) {
                throw new LanguageGrammarSemanticUtils.SemanticException(
                        "Type mismatch: cannot assign " + expressionType + " to variable '" + identifier + "' of type " + type
                );
            }
    
            semanticUtils.validateAssignment(identifier, expressionType, currentScope);
            visit(ctx.expression());
        }
    
        return null;
    }
    

    private String inferTypeFromExpression(LanguageGrammarParser.ExpressionContext expr) {
        if (expr == null) {
            return "number";  
        }
    
        String exprType = getExpressionType(expr);
        if (exprType.equals("integer") || exprType.equals("float")) {
            return "number";  
        }
    
        return exprType;  
    }
    

    @Override
    public Object visitAssignment(LanguageGrammarParser.AssignmentContext ctx) {
        String identifier = ctx.ID().getText();
        if (!semanticUtils.symbolTable.exists(identifier)) {
            throw new LanguageGrammarSemanticUtils.SemanticException(
                    "Variable '" + identifier + "' not declared in scope '" + currentScope + "'");
        }
        String expressionType = getExpressionType(ctx.expression());
        semanticUtils.validateAssignment(identifier, expressionType, currentScope);
        return visit(ctx.expression());
    }

    @Override
    public Object visitIfStatement(LanguageGrammarParser.IfStatementContext ctx) {
        visit(ctx.condition());

        String previousScope = currentScope;
        currentScope = "if_" + ctx.hashCode();

        visit(ctx.block());

        currentScope = previousScope;
        return null;
    }

    @Override
    public Object visitWhileStatement(LanguageGrammarParser.WhileStatementContext ctx) {
        visit(ctx.condition());

        String previousScope = currentScope;
        currentScope = "while_" + ctx.hashCode();

        visit(ctx.block());

        currentScope = previousScope;
        return null;
    }

    @Override
    public Object visitPrintStatement(LanguageGrammarParser.PrintStatementContext ctx) {
        if (ctx.expression() != null) {
            visit(ctx.expression());
        }
        return null;
    }

    @Override
    public Object visitInputStatement(LanguageGrammarParser.InputStatementContext ctx) {
        String identifier = ctx.ID().getText();
        if (!semanticUtils.symbolTable.exists(identifier)) {
            throw new LanguageGrammarSemanticUtils.SemanticException(
                    "Variable '" + identifier + "' not declared in scope '" + currentScope + "'");
        }
        return null;
    }

    @Override
    public Object visitBlock(LanguageGrammarParser.BlockContext ctx) {
        for (LanguageGrammarParser.DeclarationContext declaration : ctx.declaration()) {
            visit(declaration);
        }

        for (LanguageGrammarParser.StatementContext statement : ctx.statement()) {
            visit(statement);
        }

        return null;
    }

    @Override
    public Object visitExpression(LanguageGrammarParser.ExpressionContext ctx) {
        if (ctx.STRING_LITERAL() != null) {
            return "string";
        }

        Object result = visit(ctx.term(0));

        for (int i = 1; i < ctx.term().size(); i++) {
            String operator = ctx.getChild(2 * i - 1).getText();
            visit(ctx.term(i));
            validateNumericOperation(operator);
        }

        return result;
    }

    @Override
    public Object visitTerm(LanguageGrammarParser.TermContext ctx) {
        Object result = visit(ctx.factor(0));

        for (int i = 1; i < ctx.factor().size(); i++) {
            String operator = ctx.getChild(2 * i - 1).getText();
            visit(ctx.factor(i));
            validateNumericOperation(operator);
        }

        return result;
    }

    @Override
    public Object visitFactor(LanguageGrammarParser.FactorContext ctx) {
        Object result = visit(ctx.atom());

        if (ctx.EXP() != null) {
            visit(ctx.factor());
            validateNumericOperation("^");
        }

        return result;
    }

    @Override
    public Object visitAtom(LanguageGrammarParser.AtomContext ctx) {
        if (ctx.NUMBER() != null) {
            return ctx.NUMBER().getText().contains(".") ? "float" : "integer";
        }

        if (ctx.ID() != null) {
            String identifier = ctx.ID().getText();
            if (!semanticUtils.symbolTable.exists(identifier)) {
                throw new LanguageGrammarSemanticUtils.SemanticException(
                        "Variable '" + identifier + "' not declared in scope '" + currentScope + "'");
            }
            return semanticUtils.getVariableType(identifier);
        }

        if (ctx.TRUE() != null || ctx.FALSE() != null) {
            return "boolean";
        }

        if (ctx.expression() != null) {
            return visit(ctx.expression());
        }

        if (ctx.MINUS() != null) {
            Object atomType = visit(ctx.atom());
            validateNumericOperation("-");
            return atomType;
        }

        return "unknown";
    }

    private void validateNumericOperation(String operator) {

        if (!currentType.equals("number") && !currentType.equals("integer") && !currentType.equals("float")) {
            throw new LanguageGrammarSemanticUtils.SemanticException(
                    "Invalid operand type for operator '" + operator + "'. Expected numeric type.");
        }
    }

    @Override
    public Object visitCondition(LanguageGrammarParser.ConditionContext ctx) {

        visit(ctx.andCondition(0));

        for (int i = 1; i < ctx.andCondition().size(); i++) {
            visit(ctx.andCondition(i));
        }

        return "boolean";
    }

    @Override
    public Object visitAndCondition(LanguageGrammarParser.AndConditionContext ctx) {
        visit(ctx.compareCondition(0));

        for (int i = 1; i < ctx.compareCondition().size(); i++) {
            visit(ctx.compareCondition(i));
        }

        return "boolean";
    }

    @Override
    public Object visitCompareCondition(LanguageGrammarParser.CompareConditionContext ctx) {
        String leftType = getExpressionType(ctx.expression(0));

        if (ctx.comparisonOp() != null) {
            String rightType = getExpressionType(ctx.expression(1));
            validateComparison(leftType, rightType, ctx.comparisonOp().getText());
        }

        return "boolean";
    }

    private void validateComparison(String leftType, String rightType, String operator) {
        if ((operator.equals("<") || operator.equals("<=") ||
                operator.equals(">") || operator.equals(">=")) &&
                (!isNumeric(leftType) || !isNumeric(rightType))) {
            throw new LanguageGrammarSemanticUtils.SemanticException(
                    "Invalid types for numeric comparison: " + leftType + " " + operator + " " + rightType);
        }

        if ((operator.equals("==") || operator.equals("!=")) &&
                !areCompatibleTypes(leftType, rightType)) {
            throw new LanguageGrammarSemanticUtils.SemanticException(
                    "Incompatible types for equality comparison: " + leftType + " " + operator + " " + rightType);
        }
    }

    private boolean isNumeric(String type) {
        return type.equals("number") || type.equals("integer") || type.equals("float");
    }

    private boolean areCompatibleTypes(String type1, String type2) {
        if (type1.equals(type2))
            return true;
        if (isNumeric(type1) && isNumeric(type2))
            return true;
        return false;
    }

    private String getExpressionType(LanguageGrammarParser.ExpressionContext expr) {
        if (expr == null) {
            return "number";
        }
    
        if (expr.STRING_LITERAL() != null) {
            return "string";
        }
    
        String type = "integer";  
        for (LanguageGrammarParser.TermContext term : expr.term()) {
            String termType = getTermType(term);
    
            if (termType.equals("string")) {
                return "string"; 
            } else if (termType.equals("float")) {
                type = "float";  
            } else if (termType.equals("integer") && type.equals("integer")) {
                type = "integer"; 
            }
        }
    
        return type;
    }
    

    private String getTermType(LanguageGrammarParser.TermContext term) {
        String type = "number";
        for (LanguageGrammarParser.FactorContext factor : term.factor()) {
            if (factor.atom() != null) {
                String atomType = getAtomType(factor.atom());
                if (atomType.equals("string")) {
                    return atomType;
                }
            }
        }
        return type;
    }

    private String getAtomType(LanguageGrammarParser.AtomContext atom) {
        if (atom.NUMBER() != null) {
            return "number";
        }
        if (atom.ID() != null) {
            String varType = semanticUtils.getVariableType(atom.ID().getText());
            return varType != null ? varType : "number";
        }
        if (atom.expression() != null) {
            return getExpressionType(atom.expression());
        }
        return "number";
    }
}