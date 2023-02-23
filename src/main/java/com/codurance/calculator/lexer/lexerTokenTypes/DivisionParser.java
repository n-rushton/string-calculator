package com.codurance.calculator.lexer.lexerTokenTypes;

import com.codurance.calculator.lexer.TokenType;

public class DivisionParser extends LexerTokenParser {
    public DivisionParser() {
        super.regex = "/";
        super.tokenType = TokenType.DIVISION;
    }
}
