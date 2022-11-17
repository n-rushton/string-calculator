package com.codurance;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

public class AcceptanceTest {

  @Test public void add_two_numbers_together() {
    OutputWriter mockConsole = mock(OutputWriter.class);
    EquationParser parser = new TwoOperandParser();
    Operator additionOperator = new Add();
    CalculatorService calculatorService = new CalculatorService(additionOperator, mockConsole,
        parser);
    calculatorService.calculate("1 + 3");
    verify(mockConsole, times(1)).printLine("4");
  }

}
