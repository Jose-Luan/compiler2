package com.projeto;

import com.projeto.SymbolTable.Symbol;

public class LanguageGrammarPcodeGenerator extends LanguageGrammarBaseVisitor<String> {
    private SymbolTable symbolTable;
    private int currentAddress;
    private int labelCounter;

    public LanguageGrammarPcodeGenerator(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
        this.currentAddress = 0;
        this.labelCounter = 0;
    }

    @Override
    public String visitProgram(LanguageGrammarParser.ProgramContext ctx) {
        StringBuilder pcode = new StringBuilder();

        for (var decl : ctx.declaration()) {
            pcode.append(visit(decl));
        }

        for (var stmt : ctx.statement()) {
            pcode.append(visit(stmt));
        }

        pcode.append("stp\n");
        return pcode.toString();
    }

    @Override
    public String visitVarDeclaration(LanguageGrammarParser.VarDeclarationContext ctx) {
        StringBuilder pcode = new StringBuilder();
    
        if (ctx.expression() != null) {
            pcode.append("lda #").append(currentAddress).append("\n");
            pcode.append(visit(ctx.expression()));
            pcode.append("sto\n");
        }
    
        currentAddress++;
        return pcode.toString();
    }
    

    @Override
    public String visitArithExpression(LanguageGrammarParser.ArithExpressionContext ctx) {
        StringBuilder pcode = new StringBuilder();

        if (ctx.STRING_LITERAL() != null) {
            return "ldc " + ctx.STRING_LITERAL().getText() + "\n";
        }

        if (ctx.term() != null && !ctx.term().isEmpty()) {
            pcode.append(visit(ctx.term(0)));

            for (int i = 1; i < ctx.term().size(); i++) {
                pcode.append(visit(ctx.term(i)));
                String op = ctx.getChild(2 * i - 1).getText();
                switch (op) {
                    case "+":
                        pcode.append("add\n");
                        break;
                    case "-":
                        pcode.append("sub\n");
                        break;
                }
            }
        }

        return pcode.toString();
    }

    @Override
    public String visitAndCondition(LanguageGrammarParser.AndConditionContext ctx) {
        StringBuilder pcode = new StringBuilder();
        pcode.append(visit(ctx.compareCondition(0)));

        for (int i = 1; i < ctx.compareCondition().size(); i++) {
            pcode.append(visit(ctx.compareCondition(i)));
            pcode.append("and\n");
        }
        return pcode.toString();
    }

    @Override
    public String visitAssignment(LanguageGrammarParser.AssignmentContext ctx) {
        String id = ctx.ID().getText();
        Symbol symbol = symbolTable.lookup(id);
        StringBuilder pcode = new StringBuilder();

        pcode.append("lda #").append(symbol.getAddress()).append("\n");
        pcode.append(visit(ctx.arithExpression()));
        pcode.append("sto\n");

        return pcode.toString();
    }

    @Override
    public String visitTerm(LanguageGrammarParser.TermContext ctx) {
        StringBuilder pcode = new StringBuilder();
        pcode.append(visit(ctx.factor(0)));

        for (int i = 1; i < ctx.factor().size(); i++) {
            pcode.append(visit(ctx.factor(i)));
            String op = ctx.getChild(2 * i - 1).getText();
            switch (op) {
                case "*":
                    pcode.append("mul\n");
                    break;
                case "/":
                    pcode.append("div\n");
                    break;
            }
        }
        return pcode.toString();
    }

    @Override
    public String visitExpression(LanguageGrammarParser.ExpressionContext ctx) {
        if (ctx.STRING_LITERAL() != null) {
            return "ldc " + ctx.STRING_LITERAL().getText() + "\n";
        }
        if (ctx.arithExpression() != null) {
            return visit(ctx.arithExpression());
        }
        if (ctx.condition() != null) {
            return visit(ctx.condition());
        }
        return visit(ctx.term());
    }

    @Override
    public String visitAtom(LanguageGrammarParser.AtomContext ctx) {
        StringBuilder pcode = new StringBuilder();
    
        if (ctx.MINUS() != null && ctx.NUMBER() != null) {
            pcode.append("ldc ").append(ctx.NUMBER().getText()).append("\n");
            pcode.append("neg\n");
            return pcode.toString();
        }
        
        if (ctx.NUMBER() != null) {
            return "ldc " + ctx.NUMBER().getText() + "\n";
        }
        
        if (ctx.ID() != null) {
            int address = symbolTable.getAddress(ctx.ID().getText());
            return "lod #" + address + "\n";
        }
        
        if (ctx.arithExpression() != null) {
            return visit(ctx.arithExpression());
        }
        
        if (ctx.TRUE() != null) {
            return "ldc true\n";
        }
        
        if (ctx.FALSE() != null) {
            return "ldc false\n";
        }
    
        return "";
    }
    

    @Override
    public String visitIfStatement(LanguageGrammarParser.IfStatementContext ctx) {
        StringBuilder pcode = new StringBuilder();
        int label1 = labelCounter++;
        
        pcode.append(visit(ctx.condition()));
        pcode.append("fjp L").append(label1).append("\n");
        pcode.append(visit(ctx.block()));
        pcode.append("L").append(label1).append(":\n");
        
        return pcode.toString();
    }
    

    @Override
    public String visitInputStatement(LanguageGrammarParser.InputStatementContext ctx) {
        StringBuilder pcode = new StringBuilder();
        String id = ctx.ID().getText();
        Symbol symbol = symbolTable.lookup(id);

        pcode.append("lda #").append(symbol.getAddress()).append("\n");
        pcode.append("rd\n");
        pcode.append("sto\n");

        return pcode.toString();
    }

    @Override
    public String visitPrintStatement(LanguageGrammarParser.PrintStatementContext ctx) {
        StringBuilder pcode = new StringBuilder();

        if (ctx.STRING_LITERAL() != null) {
            pcode.append("ldc ").append(ctx.STRING_LITERAL().getText()).append("\n");
        } else if (ctx.expression() != null) {
            pcode.append(visit(ctx.expression()));
        }
        pcode.append("wri\n");

        return pcode.toString();
    }

    @Override
    public String visitWhileStatement(LanguageGrammarParser.WhileStatementContext ctx) {
        StringBuilder pcode = new StringBuilder();
        int startLabel = labelCounter++;
        int endLabel = labelCounter++;
        
        pcode.append("L").append(startLabel).append(":\n");
        pcode.append(visit(ctx.condition()));
        pcode.append("fjp L").append(endLabel).append("\n");
        pcode.append(visit(ctx.block()));
        pcode.append("ujp L").append(startLabel).append("\n");
        pcode.append("L").append(endLabel).append(":\n");
        
        return pcode.toString();
    }
    

    @Override
    public String visitCondition(LanguageGrammarParser.ConditionContext ctx) {
        StringBuilder pcode = new StringBuilder();

        pcode.append(visit(ctx.andCondition(0)));

        for (int i = 1; i < ctx.andCondition().size(); i++) {
            pcode.append(visit(ctx.andCondition(i)));
            pcode.append("or\n");
        }

        return pcode.toString();
    }

    @Override
    public String visitCompareCondition(LanguageGrammarParser.CompareConditionContext ctx) {
        StringBuilder pcode = new StringBuilder();
    
        if (ctx.condition() != null) {
            return visit(ctx.condition());
        }
    
        if (ctx.TRUE() != null) {
            return "ldc true\n";
        }
    
        if (ctx.FALSE() != null) {
            return "ldc false\n";
        }
    
        pcode.append(visit(ctx.arithExpression(0)));
        pcode.append(visit(ctx.arithExpression(1)));
    
        switch (ctx.comparisonOp().getText()) {
            case "<": pcode.append("let\n"); break;
            case "<=": pcode.append("lte\n"); break;
            case ">": pcode.append("grt\n"); break;
            case ">=": pcode.append("gte\n"); break;
            case "==": pcode.append("equ\n"); break;
            case "!=": pcode.append("neq\n"); break;
        }
    
        return pcode.toString();
    }
    

    @Override
    public String visitBlock(LanguageGrammarParser.BlockContext ctx) {
        StringBuilder pcode = new StringBuilder();

        for (var stmt : ctx.statement()) {
            pcode.append(visit(stmt));
        }

        return pcode.toString();
    }

}
