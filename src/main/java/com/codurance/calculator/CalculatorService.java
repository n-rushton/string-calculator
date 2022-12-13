package com.codurance.calculator;

import com.codurance.calculator.parsers.Equation;
import com.codurance.calculator.parsers.EquationParser;

public class CalculatorService {

  private final EquationParser parser;

  public CalculatorService(EquationParser parser) {
    this.parser = parser;
  }

  public int calculate(String inputString) {
    Equation equation = parser.parseExpression(inputString);

    int result = equation.execute();

    return result;
  }

}
