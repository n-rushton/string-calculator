package com.codurance.calculator.lexer;

import java.util.Objects;

public class LexerToken {

    private final TokenType tokenType;
    private final String text;
    private final int startingPos;

    public LexerToken(TokenType tokenType, String text, int startingPos) {
        this.tokenType = tokenType;
        this.text = text;
        this.startingPos = startingPos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LexerToken that = (LexerToken) o;
        return startingPos == that.startingPos && tokenType == that.tokenType && Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tokenType, text, startingPos);
    }

    @Override
    public String toString() {
        return "LexerToken{" +
                "tokenType=" + tokenType +
                ", text='" + text + '\'' +
                ", startingPos=" + startingPos +
                '}';
    }
}
