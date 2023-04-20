package com.codurance.calculator.parsers;

import com.codurance.calculator.lexer.Lexer;

public class LexerParser implements EquationParser {
    private Lexer lexer;

    public LexerParser(Lexer lexer) {
        this.lexer = lexer;
    }

    @Override
    public Equation parseExpression(String expression) {
        lexer.lex(expression);
        return null;
    }
}
