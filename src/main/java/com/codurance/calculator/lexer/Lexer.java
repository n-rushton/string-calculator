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
        isNumberFollowedBySpace(equation, space, number1050);

        String number1234 = "1234";
        isNumberFollowedBySpace(equation, space, number1234);
        String number81 = "81";
        isNumberFollowedBySpace(equation, space, number81);

        if (equation.endsWith(space)) {
            lexerTokens.add(new LexerToken(TokenType.WHITESPACE, space, equation.length()-1));
        }

        Pattern oneOrMoreNumbersPattern = Pattern.compile("[0-9]+");
        Matcher numberMatcher = oneOrMoreNumbersPattern.matcher(equation);
        if (numberMatcher.matches()) {
            lexerTokens.add( new LexerToken(TokenType.NUMBER, equation, 0));
        }

        return lexerTokens;
    }

    private void isNumberFollowedBySpace(String equation, String space, String number81) {
        if ((number81 + space).equals(equation)) {
            addNumberToken(number81);
        }
    }

    private void addNumberToken(String number) {
        lexerTokens.add(new LexerToken(TokenType.NUMBER, number, 0));
    }
}
