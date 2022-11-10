package com.codurance;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

public class CalculatorServiceTest {

  @Test
  public void service_invokes_operator() {

    Operator mockOperator = mock(Operator.class);

    CalculatorService calculatorService = new CalculatorService(mockOperator);
    calculatorService.calculate("1 + 2");

    verify(mockOperator, times(1)).execute(1, 2);
  }

}
