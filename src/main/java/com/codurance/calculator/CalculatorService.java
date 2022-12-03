package com.codurance.calculator;

import com.codurance.calculator.operators.Operator;
import com.codurance.calculator.parsers.Equation;
import com.codurance.calculator.parsers.EquationParser;
import java.util.List;

public class CalculatorService {

  private final EquationParser parser;
  private final List<Operator> operators;

  public CalculatorService(Operator operator, EquationParser parser) {
    this.operators = List.of(operator);
    this.parser = parser;

  }

  public CalculatorService(List<Operator> operators, EquationParser parser) {
    this.operators = operators;
    this.parser = parser;
  }

  public int calculate(String inputString) {
    Equation equation = parser.parseExpression(inputString);

    int result = equation.operator.execute(equation.operands.get(0), equation.operands.get(1));

    return result;
  }
}
