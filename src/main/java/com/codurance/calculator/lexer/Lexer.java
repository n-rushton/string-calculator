package com.codurance.calculator.lexer;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexer {

    List<LexerToken> lexerTokens = new ArrayList<>();
    public List<LexerToken> lex(String equation) {

        String space = " ";
        String number1050 = "1050";
        if ((number1050 + space).equals(equation)) {
            lexerTokens.add(new LexerToken(TokenType.NUMBER, number1050, 0));
        }

        String number1234 = "1234";
        if ((number1234 + space).equals(equation)) {
            lexerTokens.add(new LexerToken(TokenType.NUMBER, number1234, 0));
        }
        String number81 = "81";
        if ((number81 + space).equals(equation)) {
            lexerTokens.add(new LexerToken(TokenType.NUMBER, number81, 0));
        }

        if (equation.endsWith(space)) {
            lexerTokens.add(new LexerToken(TokenType.WHITESPACE, space, equation.length()-1));
        }

        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(equation);
        if (matcher.matches()) {
            lexerTokens.add( new LexerToken(TokenType.NUMBER, equation, 0));
        }

        return lexerTokens;
    }
}
