package com.codurance.calculator.lexer.lexerTokenTypes;

import com.codurance.calculator.lexer.LexerToken;
import com.codurance.calculator.lexer.TokenType;

public class WhitespaceParser extends LexerTokenParser {
    public WhitespaceParser() {
        super.regex = " ";
        super.tokenType = TokenType.WHITESPACE;
    }

    @Override
    public LexerToken createToken(TokenType tokenType, String foundString, int startingPos) {
        throw new UnsupportedOperationException();
    }
}
