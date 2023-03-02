package com.codurance.calculator.lexer.lexerTokenParsers;

import com.codurance.calculator.lexer.LexerToken;
import com.codurance.calculator.lexer.TokenType;

public class NumberParser extends LexerTokenParser {
    public NumberParser() {
        super.regex = "[0-9]+";
        super.tokenType = TokenType.NUMBER;
    }

    @Override
    public LexerToken createToken(String foundString, int startingPos) {
        return new LexerToken(tokenType, foundString, startingPos);
    }
}
