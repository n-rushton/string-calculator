package com.codurance.calculator.lexer.lexerTokenTypes;

import com.codurance.calculator.lexer.TokenType;

public class WhitespaceParser extends LexerTokenParser {
    public WhitespaceParser() {
        super.regex = " ";

    }
}
