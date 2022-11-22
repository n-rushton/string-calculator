package com.codurance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

public class AcceptanceTest {

  @Test public void add_two_numbers_together() {
    EquationParser parser = new TwoOperandParser();
    Operator additionOperator = new Add();
    CalculatorService calculatorService = new CalculatorService(additionOperator, parser);

    int result = calculatorService.calculate("1564 + 36574");

    assertEquals(38138, result);
  }

}
