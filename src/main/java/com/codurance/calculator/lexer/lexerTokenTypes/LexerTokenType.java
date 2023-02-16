package com.codurance.calculator.lexer.lexerTokenTypes;

import com.codurance.calculator.lexer.LexerToken;
import com.codurance.calculator.lexer.TokenType;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class LexerTokenType {
    protected String regex;
    protected TokenType tokenType;

    public List<LexerToken> extractTokens(String equation) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(equation);

        List<LexerToken> lexerTokens = new ArrayList<>();
        while (matcher.find()) {
            String foundString = matcher.group(0);
            lexerTokens.add(new LexerToken(tokenType, foundString, matcher.start(0)));
        }
        return lexerTokens;
    }
}
