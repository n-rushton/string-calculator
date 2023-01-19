package com.codurance.calculator.lexer;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexer {

    public List<LexerToken> lex(String equation) {
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(equation);
        if (matcher.find()) {
            return List.of(new LexerToken(TokenType.NUMBER, equation, 0));
        }

        return List.of(new LexerToken(TokenType.WHITESPACE, " ", 0));
    }
}
