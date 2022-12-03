package com.codurance.calculator.parsers;

import com.codurance.calculator.operators.Operator;

import java.util.List;

public class TwoOperandParser implements EquationParser {

  private final List<Operator> operators;

  public TwoOperandParser(List<Operator> operators) {
    this.operators = operators;
  }

  public List<Integer> parse(String equation) {
    String equationWithoutSpaces = equation.replace(" ", "");
    String[] operands = equationWithoutSpaces.split("(?<=\\d)[+-]");

    Integer firstInt = Integer.parseInt(operands[0]);
    Integer secondInt = Integer.parseInt(operands[1]);

    return List.of(firstInt, secondInt);
  }

  @Override
  public Equation parseExpression(String expression) {
    List<Integer> operands = parse(expression);
    Operator operator = getOperator(expression);
    return new Equation(operator, operands);
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
