package com.codurance.calculator.lexer;

import com.codurance.calculator.lexer.lexerTokenTypes.LexerTokenParser;

import java.util.ArrayList;
import java.util.List;

public class Lexer {
    private final List<LexerTokenParser> lexerTokenParsers;
    List<LexerToken> lexerTokens = new ArrayList<>();

    Lexer(List<LexerTokenParser> lexerTokenParsers) {
        this.lexerTokenParsers = lexerTokenParsers;
    }

    public List<LexerToken> lex(String equation) {

        lexerTokenParsers.forEach(lexerTokenType -> {
            lexerTokens.addAll(lexerTokenType.extractTokens(equation));
        });

        lexerTokens.sort(LexerToken::compareTo);

        return lexerTokens;
    }

}
