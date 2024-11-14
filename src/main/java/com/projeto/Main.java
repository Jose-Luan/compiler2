package com.projeto;

import java.io.IOException;
import java.io.FileWriter;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

public class Main {
    public static void main(String[] args) throws IOException {
        CharStream charStream = CharStreams.fromFileName("test.txt");
        LanguageGrammarLexer lexer = new LanguageGrammarLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LanguageGrammarParser parser = new LanguageGrammarParser(tokens);
        
        lexer.removeErrorListeners();
        parser.removeErrorListeners();
        CustomErrorListener errorListener = new CustomErrorListener();
        lexer.addErrorListener(errorListener);
        parser.addErrorListener(errorListener);

        ParseTree tree = parser.program();

        if (errorListener.hasErrors()) {
            System.out.println("\nSyntax errors found:");
            errorListener.getErrors().forEach(System.err::println);
            return;
        }

        LanguageGrammarSemantic semanticAnalyzer = new LanguageGrammarSemantic();
        boolean hasSemanticErrors = false;

        System.out.println("\nExecutando Análise Semântica...");
        try {
            semanticAnalyzer.visit(tree);
            System.out.println("Análise Semântica concluída com sucesso!");
        } catch (LanguageGrammarSemanticUtils.SemanticException e) {
            System.err.println("Erro Semântico: " + e.getMessage());
            hasSemanticErrors = true;
        } catch (Exception e) {
            System.err.println("Erro inesperado durante a análise semântica: " + e.getMessage());
            hasSemanticErrors = true;
        }

        if (!hasSemanticErrors) {
            System.out.println("\nGerando PCode...");
            LanguageGrammarPcodeGenerator pcodeGenerator = new LanguageGrammarPcodeGenerator(semanticAnalyzer.getSymbolTable());
            String pcode = pcodeGenerator.visit(tree);
            
            // Save PCode to file
            try (FileWriter writer = new FileWriter("codigo.pcode")) {
                writer.write(pcode);
                System.out.println("PCode no arquivo codigo.pcode");
            }
            
            System.out.println("PCode Gerado:");
            System.out.println(pcode);
        }
    }
}
