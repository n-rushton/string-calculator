package com.codurance;

import java.util.List;

public class TwoOperandParser implements EquationParser {

  @Override
  public List<Integer> parse(String equation) {

    StringBuilder firstString = new StringBuilder();

    for (int i = 0; i < equation.length(); i++) {
      if (' ' == equation.charAt(i)) {
        break;
      }
      firstString.append(equation.charAt(i));
    }

    Integer firstInt = Integer.parseInt(firstString.toString());

    StringBuilder secondString = new StringBuilder();

    for (int i = firstString.length() + 3; i < equation.length(); i++) {
      if (' ' == equation.charAt(i)) {
        break;
      }
      secondString.append(equation.charAt(i));
    }

    Integer secondInt = Integer.parseInt(secondString.toString());
    return List.of(firstInt, secondInt);
  }
}
