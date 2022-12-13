package com.codurance.calculator.parsers;

import com.codurance.calculator.operators.Operator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TwoOperandParser implements EquationParser {

  private final List<Operator> operators;

  public TwoOperandParser(List<Operator> operators) {
    this.operators = operators;
  }

  private List<Integer> parseIntegers(String equation) {
    String equationWithoutSpaces = equation.replace(" ", "");
    String[] operands = equationWithoutSpaces.split("(?<=\\d)[+-]");

    Integer firstInt = Integer.parseInt(operands[0]);
    Integer secondInt = Integer.parseInt(operands[1]);

    return List.of(firstInt, secondInt);
  }

  @Override
  public Equation parseExpression(String expression) {
    List<Integer> operands = parseIntegers(expression);
    Operator operator = getOperator(expression);
    return new TwoOperandEquation(operator, operands);
  }

  private Operator getOperator(String expression) {
    expression = expression.replace(" ", "");
    Pattern pattern = Pattern.compile("(?<=\\d)[+-]");
    Matcher matcher = pattern.matcher(expression);

    if (matcher.find())
    {
      for (Operator operator: operators) {
        if (matcher.group(0).contains(operator.getSymbol())) {
          return operator;
        }
      }

    }

    throw new UnsupportedOperationException();
  }

}
