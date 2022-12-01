package com.codurance.calculator.parsers;

import java.util.List;

public interface EquationParser {
    List<Integer> parse(String s);

    Equation parseExpression(String expression);
}
