package com.codurance.calculator.lexer;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Lexer {

    public static final String SPACE = " ";
    List<LexerToken> lexerTokens = new ArrayList<>();

    public List<LexerToken> lex(String equation) {

        Pattern oneOrMoreNumbersPattern = Pattern.compile("[0-9]+");
        Matcher numberMatcher = oneOrMoreNumbersPattern.matcher(equation);

        while (numberMatcher.find()) {
            String number = numberMatcher.group(0);
            lexerTokens.add(new LexerToken(TokenType.NUMBER, number, numberMatcher.start(0)));
        }

        Pattern spacePattern = Pattern.compile(SPACE);
        Matcher spaceMatcher = spacePattern.matcher(equation);

        if (spaceMatcher.find()) {
            lexerTokens.add(new LexerToken(TokenType.WHITESPACE, SPACE, spaceMatcher.start(0)));
            if (spaceMatcher.results().count() == 1) {
                lexerTokens.add(new LexerToken(TokenType.WHITESPACE, SPACE, 3));
            }
        }

        lexerTokens.sort(LexerToken::compareTo);

        return lexerTokens;
    }

}
