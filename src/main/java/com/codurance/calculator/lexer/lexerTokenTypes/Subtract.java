package com.codurance.calculator.lexer.lexerTokenTypes;

import com.codurance.calculator.lexer.TokenType;

public class Subtract extends LexerTokenType {
    public Subtract() {
        super.regex = "\\-";
        super.tokenType = TokenType.SUBTRACT;
    }
}
