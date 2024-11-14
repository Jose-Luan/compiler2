package com.projeto;

import java.io.IOException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Main {
    public static void main(String[] args) throws IOException {
        CharStream charStream = CharStreams.fromFileName("test.txt");
        LanguageGrammarLexer lexer = new LanguageGrammarLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LanguageGrammarParser parser = new LanguageGrammarParser(tokens);
        ParseTree tree = parser.program();
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
            e.printStackTrace();
            hasSemanticErrors = true;
        }

        // Geração de PCode apenas se não houver erros semânticos
        if (!hasSemanticErrors) {
            System.out.println("\nGerando PCode...");
            LanguageGrammarPcodeGenerator pcodeGenerator = new LanguageGrammarPcodeGenerator(semanticAnalyzer.getSymbolTable());
            String pcode = pcodeGenerator.visit(tree);
            System.out.println("PCode Gerado:");
            System.out.println(pcode);
        }
    }
}
