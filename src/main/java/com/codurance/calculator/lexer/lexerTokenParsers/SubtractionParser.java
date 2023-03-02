package com.codurance.calculator.lexer.lexerTokenParsers;

import com.codurance.calculator.lexer.LexerToken;
import com.codurance.calculator.lexer.TokenType;

public class SubtractionParser extends LexerTokenParser {
    public SubtractionParser() {
        super.regex = "\\-";
        super.tokenType = TokenType.SUBTRACTION;
    }

    @Override
    public LexerToken createToken(String foundString, int startingPos) {
        return new LexerToken(tokenType, foundString, startingPos);
    }
}
