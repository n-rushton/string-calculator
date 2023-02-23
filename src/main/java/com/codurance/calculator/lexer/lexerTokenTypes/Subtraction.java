package com.codurance.calculator.lexer.lexerTokenTypes;

import com.codurance.calculator.lexer.TokenType;

public class Subtraction extends LexerTokenType {
    public Subtraction() {
        super.regex = "\\-";
        super.tokenType = TokenType.SUBTRACTION;
    }
}
