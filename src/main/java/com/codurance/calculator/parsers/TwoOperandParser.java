package com.codurance.calculator.parsers;

import java.util.List;

public class TwoOperandParser implements EquationParser {

  @Override
  public List<Integer> parse(String equation) {
    String equationWithoutSpaces = equation.replace(" ", "");
    String[] operands = equationWithoutSpaces.split("(?<=\\d)[+-]");

    Integer firstInt = Integer.parseInt(operands[0]);
    Integer secondInt = Integer.parseInt(operands[1]);

    return List.of(firstInt, secondInt);
  }

}
