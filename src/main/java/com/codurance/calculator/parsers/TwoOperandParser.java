package com.codurance.calculator.parsers;

import java.util.List;

public class TwoOperandParser implements EquationParser {

  @Override
  public List<Integer> parse(String equation) {

    String[] splitEquation = equation.split("\\+");

    String firstString = splitEquation[0];
    Integer firstInt = Integer.parseInt(firstString.strip());

    String secondString = splitEquation[1];
    Integer secondInt = Integer.parseInt(secondString.strip());

    return List.of(firstInt, secondInt);
  }

}
