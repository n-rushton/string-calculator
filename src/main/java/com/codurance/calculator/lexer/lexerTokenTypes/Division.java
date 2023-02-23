package com.codurance.calculator.lexer.lexerTokenTypes;

import com.codurance.calculator.lexer.TokenType;

public class Division extends LexerTokenType {
    public Division() {
        super.regex = "/";
        super.tokenType = TokenType.DIVISION;
    }
}
