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
                        "Type mismatch: cannot assign " + expressionType + " to variable '" + identifier + "' of type "
                                + type);
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

        if (expr.STRING_LITERAL() != null) {
            return "string";
        }

        if (expr.arithExpression() != null || expr.term() != null) {
            return "number";
        }

        if (expr.condition() != null) {
            return "boolean";
        }

        return "number";
    }

    @Override
    public Object visitAssignment(LanguageGrammarParser.AssignmentContext ctx) {
        String identifier = ctx.ID().getText();

        if (!semanticUtils.symbolTable.exists(identifier)) {
            throw new LanguageGrammarSemanticUtils.SemanticException(
                    "Variable '" + identifier + "' not declared in scope '" + currentScope + "'");
        }

        String expressionType = getArithExpressionType(ctx.arithExpression());
        semanticUtils.validateAssignment(identifier, expressionType, currentScope);

        return visit(ctx.arithExpression());
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
        if (ctx.arithExpression() != null) {
            return visit(ctx.arithExpression());
        }
        if (ctx.condition() != null) {
            return visit(ctx.condition());
        }
        if (ctx.term() != null) {
            return visit(ctx.term());
        }
        return "unknown";
    }

    @Override
    public Object visitTerm(LanguageGrammarParser.TermContext ctx) {
        currentType = "number";
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
        currentType = "number";
        Object result = visit(ctx.atom());

        if (ctx.EXP() != null) {
            visit(ctx.factor());
            validateNumericOperation("^");
        }

        return result;
    }

    @Override
    public Object visitAtom(LanguageGrammarParser.AtomContext ctx) {
        if (ctx.MINUS() != null && ctx.NUMBER() != null) {
            return "number";
        }
    
        if (ctx.NUMBER() != null) {
            return "number";
        }
    
        if (ctx.ID() != null) {
            String identifier = ctx.ID().getText();
            if (!semanticUtils.symbolTable.exists(identifier)) {
                throw new LanguageGrammarSemanticUtils.SemanticException(
                        "Variable '" + identifier + "' not declared in scope '" + currentScope + "'");
            }
            return semanticUtils.getVariableType(identifier);
        }
    
        if (ctx.arithExpression() != null) {
            return visit(ctx.arithExpression());
        }
    
        if (ctx.TRUE() != null || ctx.FALSE() != null) {
            return "boolean";
        }
    
        return "unknown";
    }
    

    private void validateNumericOperation(String operator) {
        if (!currentType.equals("number")) {
            throw new LanguageGrammarSemanticUtils.SemanticException(
                    "Invalid operand type for operator '" + operator + "'. Expected numeric type.");
        }
    }

    @Override
    public Object visitCondition(LanguageGrammarParser.ConditionContext ctx) {
        String conditionType = getConditionType(ctx);

        if (!conditionType.equals("boolean")) {
            throw new LanguageGrammarSemanticUtils.SemanticException(
                    "Condition must be a boolean expression.");
        }
        return conditionType;
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
        if (ctx.condition() != null) {
            return visit(ctx.condition());
        }

        if (ctx.TRUE() != null || ctx.FALSE() != null) {
            return "boolean";
        }

        if (ctx.arithExpression() != null) {
            Object type1 = visit(ctx.arithExpression(0));
            Object type2 = visit(ctx.arithExpression(1));

            if (!type1.equals(type2)) {
                throw new LanguageGrammarSemanticUtils.SemanticException(
                        "Type mismatch in comparison: " + type1 + " and " + type2);
            }
            return "boolean";
        }

        return "boolean";
    }

    @Override
    public Object visitArithExpression(LanguageGrammarParser.ArithExpressionContext ctx) {
        if (ctx.STRING_LITERAL() != null) {
            if (ctx.arithExpression() != null) {
                Object rightType = visit(ctx.arithExpression());
                if (!rightType.equals("string")) {
                    throw new LanguageGrammarSemanticUtils.SemanticException(
                            "Cannot add " + rightType + " to string");
                }
            }
            return "string";
        }

        Object type = visit(ctx.term(0));
        for (int i = 1; i < ctx.term().size(); i++) {
            Object nextType = visit(ctx.term(i));
            if (!type.equals(nextType) || type.equals("string")) {
                throw new LanguageGrammarSemanticUtils.SemanticException(
                        "Invalid operation between types " + type + " and " + nextType);
            }
        }
        return type;
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

    private String getConditionType(LanguageGrammarParser.ConditionContext condition) {
        for (LanguageGrammarParser.AndConditionContext andCondition : condition.andCondition()) {
            String andConditionType = getAndConditionType(andCondition);

            if (!andConditionType.equals("boolean")) {
                throw new LanguageGrammarSemanticUtils.SemanticException(
                        "Expected boolean expression in condition.");
            }
        }
        return "boolean";
    }

    private String getAndConditionType(LanguageGrammarParser.AndConditionContext andCondition) {
        for (LanguageGrammarParser.CompareConditionContext compareCondition : andCondition.compareCondition()) {
            String compareConditionType = getCompareConditionType(compareCondition);

            if (!compareConditionType.equals("boolean")) {
                throw new LanguageGrammarSemanticUtils.SemanticException(
                        "Expected boolean expression in 'and' condition.");
            }
        }
        return "boolean";
    }

    private String getCompareConditionType(LanguageGrammarParser.CompareConditionContext compareCondition) {
        if (compareCondition.condition() != null) {
            return getConditionType(compareCondition.condition());
        }

        String leftType = getArithExpressionType(compareCondition.arithExpression(0));
        if (compareCondition.comparisonOp() != null) {
            String rightType = getArithExpressionType(compareCondition.arithExpression(1));
            validateComparison(leftType, rightType, compareCondition.comparisonOp().getText());
        }
        return "boolean";
    }

    private String getExpressionType(LanguageGrammarParser.ExpressionContext ctx) {
        if (ctx == null) {
            return "number";
        }

        if (ctx.STRING_LITERAL() != null) {
            return "string";
        }
        if (ctx.arithExpression() != null) {
            return "number";
        }
        if (ctx.condition() != null) {
            return "boolean";
        }
        if (ctx.term() != null) {
            return "number";
        }

        return "number";
    }

    private String getArithExpressionType(LanguageGrammarParser.ArithExpressionContext expr) {
        return "number";
    }

}