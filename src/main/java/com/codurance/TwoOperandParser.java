package com.codurance;

import java.util.List;

public class TwoOperandParser implements EquationParser {

  @Override
  public List<Integer> parse(String equation) {

    StringBuilder firstString = parseInteger(equation, 0);
    Integer firstInt = Integer.parseInt(firstString.toString());

    StringBuilder secondString = parseInteger(equation, firstString.length() + 3);
    Integer secondInt = Integer.parseInt(secondString.toString());

    return List.of(firstInt, secondInt);
  }

  private static StringBuilder parseInteger(String equation, int startingPosition) {
    StringBuilder firstString = new StringBuilder();
    for (int i = startingPosition; i < equation.length(); i++) {
      if (' ' == equation.charAt(i)) {
        break;
      }
      firstString.append(equation.charAt(i));
    }
    return firstString;
  }
}
