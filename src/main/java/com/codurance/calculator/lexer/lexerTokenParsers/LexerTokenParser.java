package com.codurance.calculator.lexer.lexerTokenParsers;

import com.codurance.calculator.lexer.LexerToken;
import com.codurance.calculator.lexer.TokenType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class LexerTokenParser {
    protected String regex;
    protected TokenType tokenType;

    public abstract LexerToken createToken(String foundString, int startingPos);

    public Matcher match(String equation) {
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(equation);
    }
}
