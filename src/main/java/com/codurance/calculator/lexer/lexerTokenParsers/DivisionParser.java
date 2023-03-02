package com.codurance.calculator.lexer.lexerTokenParsers;

import com.codurance.calculator.lexer.LexerToken;
import com.codurance.calculator.lexer.TokenType;

public class DivisionParser extends LexerTokenParser {
    public DivisionParser() {
        super.regex = "/";
        super.tokenType = TokenType.DIVISION;
    }

    @Override
    public LexerToken createToken(String foundString, int startingPos) {
        return new LexerToken(tokenType, foundString, startingPos);
    }
}
