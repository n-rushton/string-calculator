package com.codurance.calculator.lexer.lexerTokenTypes;

import com.codurance.calculator.lexer.TokenType;

public class Whitespace extends LexerTokenType {
    public Whitespace() {
        super.regex = " ";
        super.tokenType = TokenType.WHITESPACE;
    }
}
