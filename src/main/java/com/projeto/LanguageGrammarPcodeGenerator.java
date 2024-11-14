package com.projeto;

import java.util.Map;

import com.projeto.SymbolTable.Symbol;

public class LanguageGrammarPcodeGenerator extends LanguageGrammarBaseVisitor<String> {
    private SymbolTable symbolTable;
    private int currentAddress;

    public LanguageGrammarPcodeGenerator(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
        this.currentAddress = 0;
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
    public String visitDeclaration(LanguageGrammarParser.DeclarationContext ctx) {
        return visit(ctx.varDeclaration());
    }

    @Override
    public String visitVarDeclaration(LanguageGrammarParser.VarDeclarationContext ctx) {
        String id = ctx.ID().getText();

        symbolTable.insert(id, "number", symbolTable.getCurrentScope(), currentAddress);

        StringBuilder pcode = new StringBuilder();
        pcode.append("lda #").append(currentAddress).append("\n");
        pcode.append("ldc 0\n"); 
        pcode.append("sto\n");

        currentAddress++;
        return pcode.toString();
    }

    @Override
    public String visitAssignment(LanguageGrammarParser.AssignmentContext ctx) {
        String id = ctx.ID().getText();
        Symbol symbol = symbolTable.lookup(id);

        StringBuilder pcode = new StringBuilder();
        pcode.append("lda #").append(symbol.getAddress()).append("\n");
        pcode.append(visit(ctx.expression()));
        pcode.append("sto\n");
        return pcode.toString();
    }

    @Override
    public String visitExpression(LanguageGrammarParser.ExpressionContext ctx) {
        StringBuilder pcode = new StringBuilder();
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
    public String visitFactor(LanguageGrammarParser.FactorContext ctx) {
        StringBuilder pcode = new StringBuilder();
        pcode.append(visit(ctx.atom()));

        if (ctx.factor() != null) {
            pcode.append(visit(ctx.factor()));
            pcode.append("exp\n");
        }
        return pcode.toString();
    }

    @Override
    public String visitAtom(LanguageGrammarParser.AtomContext ctx) {
        if (ctx.NUMBER() != null) {
            return "ldc " + ctx.NUMBER().getText() + "\n";
        }
        if (ctx.ID() != null) {
            int address = symbolTable.getAddress(ctx.ID().getText());
            return "lod #" + address + "\n";
        }
        if (ctx.expression() != null) {
            return visit(ctx.expression());
        }
        if (ctx.MINUS() != null) {
            return visit(ctx.atom()) + "neg\n";
        }
        return "";
    }

    @Override
    public String visitPrintStatement(LanguageGrammarParser.PrintStatementContext ctx) {
        StringBuilder pcode = new StringBuilder();

        pcode.append(visit(ctx.expression()));
        pcode.append("wri\n");

        return pcode.toString();
    }

    @Override
    public String visitInputStatement(LanguageGrammarParser.InputStatementContext ctx) {
        String id = ctx.ID().getText();
        Symbol symbol = symbolTable.lookup(id);
        StringBuilder pcode = new StringBuilder();
        pcode.append("lda #").append(symbol.getScope()).append("\n");
        pcode.append("rdi\n");
        return pcode.toString();
    }

    private int labelCounter = 0;

    private String generateLabel() {
        return "L" + (labelCounter++);
    }

    @Override
    public String visitIfStatement(LanguageGrammarParser.IfStatementContext ctx) {
        StringBuilder pcode = new StringBuilder();
        String endLabel = generateLabel();
        String elseLabel = generateLabel();

        pcode.append(visit(ctx.condition()));

        pcode.append("fjp ").append(elseLabel).append("\n");

        pcode.append(visit(ctx.block()));
        pcode.append("ujp ").append(endLabel).append("\n");

        pcode.append(endLabel).append(":\n");
        return pcode.toString();
    }

    @Override
    public String visitWhileStatement(LanguageGrammarParser.WhileStatementContext ctx) {
        StringBuilder pcode = new StringBuilder();
        String startLabel = generateLabel();
        String endLabel = generateLabel();

        pcode.append(startLabel).append(":\n");

        pcode.append(visit(ctx.condition()));

        pcode.append("fjp ").append(endLabel).append("\n");

        pcode.append(visit(ctx.block()));

        pcode.append("ujp ").append(startLabel).append("\n");

        pcode.append(endLabel).append(":\n");

        return pcode.toString();
    }

    private int scopeLevel = 0;

    private void enterScope() {
        String scopeName = "scope" + scopeLevel;
        scopeLevel++;
        symbolTable.enterScope(scopeName);
    }

    private void exitScope() {
        Map<String, Symbol> currentScopeSymbols = symbolTable.getScopedSymbols().get(symbolTable.getCurrentScope());
        if (currentScopeSymbols != null) {
            for (Symbol symbol : currentScopeSymbols.values()) {
                currentAddress--;
            }
        }
        scopeLevel--;
        symbolTable.exitScope();
    }

    @Override
    public String visitBlock(LanguageGrammarParser.BlockContext ctx) {
        StringBuilder pcode = new StringBuilder();

        enterScope();

        for (var stmt : ctx.statement()) {
            pcode.append(visit(stmt));
        }

        exitScope();

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
    public String visitCompareCondition(LanguageGrammarParser.CompareConditionContext ctx) {
        StringBuilder pcode = new StringBuilder();

        pcode.append(visit(ctx.expression(0)));

        if (ctx.comparisonOp() != null) {
            pcode.append(visit(ctx.expression(1)));

            switch (ctx.comparisonOp().getText()) {
                case "<":
                    pcode.append("les\n");
                    break;
                case "<=":
                    pcode.append("leq\n");
                    break;
                case ">":
                    pcode.append("grt\n");
                    break;
                case ">=":
                    pcode.append("geq\n");
                    break;
                case "==":
                    pcode.append("equ\n");
                    break;
                case "!=":
                    pcode.append("neq\n");
                    break;
            }
        }

        return pcode.toString();
    }

}
