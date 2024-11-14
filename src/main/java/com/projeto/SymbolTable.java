package com.projeto;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SymbolTable {
    private Map<String, Map<String, Symbol>> scopedSymbols;
    private Stack<String> scopeStack;

    public SymbolTable() {
        this.scopedSymbols = new HashMap<>();
        this.scopeStack = new Stack<>();
        this.scopeStack.push("global");
        this.scopedSymbols.put("global", new HashMap<>());
    }

    public void insert(String name, String type, String scope, int address) {
        Map<String, Symbol> scopeSymbols = scopedSymbols.computeIfAbsent(scope, k -> new HashMap<>());
        Symbol symbol = new Symbol(name, type, scope, address); 
        scopeSymbols.put(name, symbol);
    }
    

    public Symbol lookup(String name) {
        for (int i = scopeStack.size() - 1; i >= 0; i--) {
            String scope = scopeStack.get(i);
            Map<String, Symbol> scopeSymbols = scopedSymbols.get(scope);
            if (scopeSymbols != null && scopeSymbols.containsKey(name)) {
                return scopeSymbols.get(name);
            }
        }
        return null;
    }

    public boolean exists(String name) {
        return lookup(name) != null;
    }

    public void enterScope(String scope) {
        scopeStack.push(scope);
        scopedSymbols.putIfAbsent(scope, new HashMap<>());
    }

    public void exitScope() {
        if (scopeStack.size() > 1) {
            scopeStack.pop();
        }
    }

    public String getCurrentScope() {
        return scopeStack.peek();
    }

    public Map<String, Map<String, Symbol>> getScopedSymbols() {
        return scopedSymbols;
    }

    public int getAddress(String name) {
        Symbol symbol = lookup(name);
        return symbol != null ? symbol.getAddress() : -1;
    }
    

    public void clear() {
        scopedSymbols.clear();
        scopeStack.clear();
        scopeStack.push("global");
        scopedSymbols.put("global", new HashMap<>());
    }

    public static class Symbol {
        private final String name;
        private final String type;
        private final String scope;
        private final int address; 
        private Object value;
    
        public Symbol(String name, String type, String scope, int address) {
            this.name = name;
            this.type = type;
            this.scope = scope;
            this.address = address;
        }
    
        public String getName() { return name; }
        public String getType() { return type; }
        public String getScope() { return scope; }
        public int getAddress() { return address; } 
        public Object getValue() { return value; }
        public void setValue(Object value) { this.value = value; }
    }
    
}
