package com.codurance.calculator;

import com.codurance.calculator.operators.Operator;
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
    List<Integer> operands = parser.parse(inputString);

    Operator operator = getOperator(inputString);

    int result = operator.execute(operands.get(0), operands.get(1));

    return result;
  }

  private Operator getOperator(String expression) {
    for (Operator operator: operators) {
      if (expression.contains(operator.getSymbol())) {
        return operator;
      }
    }

    throw new UnsupportedOperationException();
  }
}
