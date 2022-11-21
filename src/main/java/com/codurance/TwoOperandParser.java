package com.codurance;

import java.util.List;

public class TwoOperandParser implements EquationParser {

  @Override
  public List<Integer> parse(String equation) {

    String firstString = "";

    for (int i = 0; i < equation.length(); i++) {
      if (' ' == equation.charAt(i)) {
        break;
      }
      firstString += equation.charAt(i);
    }

    Integer firstInt = Integer.parseInt(firstString);

    char secondChar = equation.charAt(equation.length() - 1);
    String secondString = String.valueOf(secondChar);
    Integer secondInt = Integer.parseInt(secondString);
    return List.of(firstInt, secondInt);
  }
}
