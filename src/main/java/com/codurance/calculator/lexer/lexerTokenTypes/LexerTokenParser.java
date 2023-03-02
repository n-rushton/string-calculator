package com.codurance.calculator.lexer.lexerTokenTypes;

import com.codurance.calculator.lexer.LexerToken;
import com.codurance.calculator.lexer.TokenType;

public abstract class LexerTokenParser {
    public String regex;
    public TokenType tokenType;

    public abstract LexerToken createToken(TokenType tokenType, String foundString, int startingPos);
}
