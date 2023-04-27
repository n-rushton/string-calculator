package com.codurance.calculator.parsers;

import com.codurance.calculator.lexer.LexerToken;

import java.util.List;
import java.util.Objects;

public class TokenEquation extends Equation {
    private final List<LexerToken> lexerTokens;

    public TokenEquation(List<LexerToken> lexerTokens) {
        this.lexerTokens = lexerTokens;
    }

    @Override
    public int execute() {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TokenEquation that = (TokenEquation) o;
        return Objects.equals(lexerTokens, that.lexerTokens);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lexerTokens);
    }
}
