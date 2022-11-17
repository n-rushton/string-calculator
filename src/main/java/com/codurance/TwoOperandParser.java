package com.codurance;

import java.util.List;

public class TwoOperandParser implements EquationParser {

  @Override
  public List<Integer> parse(String s) {
    char firstChar = s.charAt(0);
    String firstString = String.valueOf(firstChar);
    Integer firstInt = Integer.parseInt(firstString);

    char secondChar = s.charAt(s.length() - 1);
    String secondString = String.valueOf(secondChar);
    Integer secondInt = Integer.parseInt(secondString);
    return List.of(firstInt, secondInt);
  }
}
