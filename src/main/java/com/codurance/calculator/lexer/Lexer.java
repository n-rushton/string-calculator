package com.codurance.calculator.lexer;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexer {

    public static final String SPACE = " ";
    List<LexerToken> lexerTokens = new ArrayList<>();

    public List<LexerToken> lex(String equation) {

        Pattern oneOrMoreNumbersPattern = Pattern.compile("[0-9]+");
        Matcher numberMatcher = oneOrMoreNumbersPattern.matcher(equation);

        if (numberMatcher.find()) {
            String number = numberMatcher.group(0);
            lexerTokens.add(new LexerToken(TokenType.NUMBER, number, 0));
        }

        if (equation.endsWith(SPACE)) {
            lexerTokens.add(new LexerToken(TokenType.WHITESPACE, SPACE, equation.length() - 1));
        }

        return lexerTokens;
    }

}
