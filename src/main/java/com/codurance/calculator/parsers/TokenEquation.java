package com.codurance.calculator.parsers;

import com.codurance.calculator.lexer.LexerToken;
import com.codurance.calculator.lexer.TokenType;

import java.util.List;
import java.util.Objects;

import static java.lang.Integer.parseInt;

public class TokenEquation extends Equation {
    private final List<LexerToken> lexerTokens;

    public TokenEquation(List<LexerToken> lexerTokens) {
        this.lexerTokens = lexerTokens;
    }

    @Override
    public int execute() {
        if (lexerTokens.get(1).tokenType == TokenType.SUBTRACTION) {
            return parseInt(lexerTokens.get(0).text) - parseInt(lexerTokens.get(2).text);
        }
        return parseInt(lexerTokens.get(0).text) + parseInt(lexerTokens.get(2).text);
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
