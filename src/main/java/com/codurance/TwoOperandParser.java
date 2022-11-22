package com.codurance;

import java.util.List;

public class TwoOperandParser implements EquationParser {

  @Override
  public List<Integer> parse(String equation) {

    String[] splitEquation = equation.split(" ");

    String firstString = splitEquation[0];
    Integer firstInt = Integer.parseInt(firstString);

    String secondString = splitEquation[2];
    Integer secondInt = Integer.parseInt(secondString);

    return List.of(firstInt, secondInt);
  }

}
