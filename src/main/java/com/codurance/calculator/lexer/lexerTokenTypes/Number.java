package com.codurance.calculator.lexer.lexerTokenTypes;

import com.codurance.calculator.lexer.TokenType;

public class Number extends LexerTokenType {
    public Number() {
        super.regex = "[0-9]+";
        super.tokenType = TokenType.NUMBER;
    }
}
