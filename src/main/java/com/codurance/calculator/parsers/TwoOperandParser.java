package com.codurance.calculator.parsers;

import com.codurance.calculator.operators.Operator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TwoOperandParser implements EquationParser {

  private final List<Operator> operators;
  private final String findOperatorsRegex;

  public TwoOperandParser(List<Operator> operators) {
    this.operators = operators;
    this.findOperatorsRegex = String.format("(?<=\\d)[%s]", getOperatorSymbol(operators));
  }

  private String getOperatorSymbol(List<Operator> operators) {
    return operators.stream().map(Operator::getSymbol).collect(Collectors.joining());
  }

  private List<Integer> parseIntegers(String equation) {
    String equationWithoutSpaces = equation.replace(" ", "");
    String[] operands = equationWithoutSpaces.split(findOperatorsRegex);

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
    Pattern pattern = Pattern.compile(findOperatorsRegex);
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
