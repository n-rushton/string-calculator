package com.codurance;

import java.util.List;

public class TwoOperandParser implements EquationParser {

  @Override
  public List<Integer> parse(String s) {

    char firstChar = s.charAt(0);
    String firstString = String.valueOf(firstChar);
    if (' ' != s.charAt(1)) {
      char secondCharFirstNumber = s.charAt(1);
      firstString = firstString.concat(String.valueOf(secondCharFirstNumber));

      if (' ' != s.charAt(2)) {
        char thirdCharFirstNumber = s.charAt(2);
        firstString = firstString.concat(String.valueOf(thirdCharFirstNumber));
      }
    }
    Integer firstInt = Integer.parseInt(firstString);

    char secondChar = s.charAt(s.length() - 1);
    String secondString = String.valueOf(secondChar);
    Integer secondInt = Integer.parseInt(secondString);
    return List.of(firstInt, secondInt);
  }
}
