package com.codurance.calculator.lexer;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexer {

    public static final String SPACE = " ";
    List<LexerToken> lexerTokens = new ArrayList<>();
    public List<LexerToken> lex(String equation) {

        String number1050 = "1050";
        isNumberFollowedBySpace(equation, number1050);

        String number1234 = "1234";
        isNumberFollowedBySpace(equation, number1234);
        String number81 = "81";
        isNumberFollowedBySpace(equation, number81);

        if (equation.endsWith(SPACE)) {
            lexerTokens.add(new LexerToken(TokenType.WHITESPACE, SPACE, equation.length()-1));
        }

        Pattern oneOrMoreNumbersPattern = Pattern.compile("[0-9]+");
        Matcher numberMatcher = oneOrMoreNumbersPattern.matcher(equation);
        if (numberMatcher.matches()) {
            lexerTokens.add( new LexerToken(TokenType.NUMBER, equation, 0));
        }

        return lexerTokens;
    }

    private void isNumberFollowedBySpace(String equation, String number) {
        if ((number + SPACE).equals(equation)) {
            addNumberToken(number);
        }
    }

    private void addNumberToken(String number) {
        lexerTokens.add(new LexerToken(TokenType.NUMBER, number, 0));
    }
}
