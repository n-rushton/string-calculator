package com.codurance.calculator.parsers;

import java.util.List;

public interface EquationParser {
    Equation parseExpression(String expression);
}
