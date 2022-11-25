package com.codurance.calculator.parsers;

import java.util.List;

public class TwoOperandParser implements EquationParser {

  @Override
  public List<Integer> parse(String equation) {
    String equationWithoutSpaces = equation.replace(" ", "");
    String[] splitEquation = equationWithoutSpaces.split("(?<=\\d)[+-]");

    String firstString = splitEquation[0];
    Integer firstInt = Integer.parseInt(firstString);

    String secondString = splitEquation[1];
    Integer secondInt = Integer.parseInt(secondString);

    return List.of(firstInt, secondInt);
  }

}
