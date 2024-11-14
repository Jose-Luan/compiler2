package com.projeto;

import org.antlr.v4.runtime.*;

public class CustomErrorListener extends BaseErrorListener {
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                          Object offendingSymbol,
                          int line,
                          int charPositionInLine,
                          String msg,
                          RecognitionException e) {
        
        StringBuilder errorMessage = new StringBuilder();
        errorMessage.append("\nError at line ").append(line).append(", position ").append(charPositionInLine).append(":\n");
        errorMessage.append("Syntax error: ").append(msg);
        
        System.err.println(errorMessage.toString());
    }
}