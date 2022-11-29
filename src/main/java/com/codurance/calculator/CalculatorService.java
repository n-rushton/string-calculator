package com.codurance.calculator;

import com.codurance.calculator.operators.Operator;
import com.codurance.calculator.parsers.EquationParser;
import java.util.List;

public class CalculatorService {

  private final Operator operator;
  private final EquationParser parser;

  public CalculatorService(Operator operator, EquationParser parser) {
    this.operator = operator;
    this.parser = parser;
  }

  public CalculatorService(List<Operator> operators, EquationParser parser) {
    throw new UnsupportedOperationException();
  }

  public int calculate(String s) {
    List<Integer> operands = parser.parse(s);

    int result = operator.execute(operands.get(0), operands.get(1));

    return result;
  }
}
