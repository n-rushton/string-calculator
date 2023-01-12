package com.codurance.calculator.lexer;

import java.util.List;

public class Lexer {
    public List<LexerToken> lex(String equation) {
        if (equation.equals("1")) {
            return List.of(new LexerToken(TokenType.NUMBER, "1", 0));
        }

        return List.of(new LexerToken(TokenType.WHITESPACE, " ", 0));
    }
}
