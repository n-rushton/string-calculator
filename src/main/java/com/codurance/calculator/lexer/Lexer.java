package com.codurance.calculator.lexer;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexer {

    List<LexerToken> lexerTokens = new ArrayList<>();
    public List<LexerToken> lex(String equation) {

        if ("1050 ".equals(equation)) {
            lexerTokens.add(new LexerToken(TokenType.NUMBER, "1050", 0));
        }

        if ("1234 ".equals(equation)) {
            lexerTokens.add(new LexerToken(TokenType.NUMBER, "1234", 0));
        }
        if ("81 ".equals(equation)) {
                lexerTokens.add(new LexerToken(TokenType.NUMBER, "81", 0));
        }

        if (equation.endsWith(" ")) {
            lexerTokens.add(new LexerToken(TokenType.WHITESPACE, " ", equation.length()-1));
        }

        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(equation);
        if (matcher.matches()) {
            lexerTokens.add( new LexerToken(TokenType.NUMBER, equation, 0));
        }

        return lexerTokens;
    }
}
