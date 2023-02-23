package com.codurance.calculator.lexer.lexerTokenTypes;

import com.codurance.calculator.lexer.TokenType;

public class NumberParser extends LexerTokenParser {
    public NumberParser() {
        super.regex = "[0-9]+";
        super.tokenType = TokenType.NUMBER;
    }
}
