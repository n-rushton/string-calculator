package com.codurance.calculator.lexer.lexerTokenTypes;

import com.codurance.calculator.lexer.LexerToken;
import com.codurance.calculator.lexer.TokenType;

public class SubtractionParser extends LexerTokenParser {
    public SubtractionParser() {
        super.regex = "\\-";
        super.tokenType = TokenType.SUBTRACTION;
    }

    @Override
    public LexerToken createToken(TokenType tokenType, String foundString, int startingPos) {
        throw new UnsupportedOperationException();
    }
}
