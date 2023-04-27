package com.codurance.calculator.parsers;

import com.codurance.calculator.lexer.Lexer;
import com.codurance.calculator.lexer.LexerToken;

import java.util.List;

public class LexerParser implements EquationParser {
    private Lexer lexer;

    public LexerParser(Lexer lexer) {
        this.lexer = lexer;
    }

    @Override
    public Equation parseExpression(String expression) {
        List<LexerToken> lexerTokens = lexer.lex(expression);
        return new TokenEquation(lexerTokens);
    }
}
