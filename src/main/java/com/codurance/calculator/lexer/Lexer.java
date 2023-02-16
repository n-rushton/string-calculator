package com.codurance.calculator.lexer;

import com.codurance.calculator.lexer.lexerTokenTypes.LexerTokenType;

import java.util.ArrayList;
import java.util.List;

public class Lexer {
    private final List<LexerTokenType> lexerTokenTypes;
    List<LexerToken> lexerTokens = new ArrayList<>();

    Lexer(List<LexerTokenType> lexerTokenTypes) {
        this.lexerTokenTypes = lexerTokenTypes;
    }

    public List<LexerToken> lex(String equation) {

        lexerTokenTypes.forEach(lexerTokenType -> {
            lexerTokens.addAll(lexerTokenType.extractTokens(equation));
        });

        lexerTokens.sort(LexerToken::compareTo);

        return lexerTokens;
    }

}
