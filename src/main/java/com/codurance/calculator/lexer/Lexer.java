package com.codurance.calculator.lexer;

import com.codurance.calculator.lexer.lexerTokenTypes.LexerTokenParser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexer {
    private final List<LexerTokenParser> lexerTokenParsers;

    Lexer(List<LexerTokenParser> lexerTokenParsers) {
        this.lexerTokenParsers = lexerTokenParsers;
    }

    public List<LexerToken> lex(String equation) {
        List<LexerToken> lexerTokens = new ArrayList<>();

        lexerTokenParsers.forEach(lexerTokenParser -> {
            Pattern pattern = Pattern.compile(lexerTokenParser.regex);
            Matcher matcher = pattern.matcher(equation);

            while (matcher.find()) {
                String foundString = matcher.group(0);
//                lexerTokens.add(new LexerToken(lexerTokenParser.tokenType, foundString, matcher.start(0)));
                lexerTokens.add(lexerTokenParser.createToken(lexerTokenParser.tokenType, foundString, matcher.start(0)));
            }
        });

        lexerTokens.sort(LexerToken::compareTo);

        return lexerTokens;
    }

}
