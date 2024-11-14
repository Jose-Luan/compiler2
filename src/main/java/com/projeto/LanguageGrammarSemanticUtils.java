package com.projeto;

import com.projeto.SymbolTable.Symbol;

public class LanguageGrammarSemanticUtils {
    public SymbolTable symbolTable;

    public LanguageGrammarSemanticUtils() {
        this.symbolTable = new SymbolTable();
    }

    public void validateDeclaration(String identifier, String type, int address, String scope) {
        Symbol existingSymbol = symbolTable.lookup(identifier);
        if (existingSymbol != null && existingSymbol.getScope().equals(scope)) {
            throw new SemanticException("Variable '" + identifier + "' already declared in scope '" + scope + "'");
        }
        symbolTable.insert(identifier, type, scope, address);
    }
    

    public void validateAssignment(String identifier, String expressionType, String scope) {
        Symbol symbol = symbolTable.lookup(identifier);
        if (symbol == null) {
            throw new SemanticException("Variable '" + identifier + "' not declared in scope '" + scope + "'");
        }

        if (!isNumericType(expressionType)) {
            throw new SemanticException("Type mismatch: Cannot assign non-numeric type to variable '" + identifier + "'");
        }
    }

    private boolean isNumericType(String type) {
        return type.equals("number") || type.equals("integer") || type.equals("float");
    }

    public String getVariableType(String identifier) {
        Symbol symbol = symbolTable.lookup(identifier);
        if (symbol == null) {
            throw new SemanticException("Variable '" + identifier + "' not declared");
        }
        return "number";
    }

    public void enterScope(String scope) {
        symbolTable.enterScope(scope);
    }

    public void exitScope() {
        symbolTable.exitScope();
    }

    public static class SemanticException extends RuntimeException {
        public SemanticException(String message) {
            super(message);
        }
    }
}