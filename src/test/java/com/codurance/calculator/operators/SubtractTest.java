package com.codurance.calculator.operators;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SubtractTest {

  @ParameterizedTest
  @CsvSource({
      "5,3,2",
      "10,4,6",
      "-4,20,-24"
  })
  public void add_two_numbers_together(int firstNumber, int secondNumber, int expectedAnswer) {
    Subtract operator = new Subtract();

    int result = operator.execute(firstNumber, secondNumber);

    assertEquals(expectedAnswer, result);
  }

}