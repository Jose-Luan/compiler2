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

        String varType = symbol.getType();
        if (!areTypesCompatible(varType, expressionType)) {
            throw new SemanticException("Type mismatch: Cannot assign " + expressionType + " to variable '" + identifier + "' of type " + varType);
        }
    }

    private boolean areTypesCompatible(String varType, String exprType) {
        if (varType.equals(exprType)) return true;
        if (varType.equals("number") && (exprType.equals("integer") || exprType.equals("float"))) return true;
        if (isNumericType(varType) && isNumericType(exprType)) return true;
        if (varType.equals("string") && exprType.equals("string")) return true;
        if (varType.equals("boolean") && exprType.equals("boolean")) return true;
        return false;
    }
    

    private boolean isNumericType(String type) {
        return type.equals("number");  
    }

    public String getVariableType(String identifier) {
        Symbol symbol = symbolTable.lookup(identifier);
        if (symbol == null) {
            throw new SemanticException("Variable '" + identifier + "' not declared");
        }
        return symbol.getType();
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
