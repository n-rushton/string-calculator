package com.codurance.calculator.lexer.lexerTokenParsers;

import com.codurance.calculator.lexer.LexerToken;
import com.codurance.calculator.lexer.TokenType;

public abstract class LexerTokenParser {
    public String regex;
    protected TokenType tokenType;

    public abstract LexerToken createToken(String foundString, int startingPos);
}
