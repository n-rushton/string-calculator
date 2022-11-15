package com.codurance;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class CalculatorServiceTest {

  @Test
  public void service_invokes_operator() {

    Operator mockOperator = mock(Operator.class);
    OutputWriter mockOutputWriter = mock(OutputWriter.class);

    CalculatorService calculatorService = new CalculatorService(mockOperator, mockOutputWriter);
    calculatorService.calculate("1 + 2");

    verify(mockOperator, times(1)).execute(1, 2);
  }

  @Test
  public void service_invokes_parser() {
    EquationParser mockParser = mock(EquationParser.class);
    Operator mockOperator = mock(Operator.class);
    OutputWriter mockOutputWriter = mock(OutputWriter.class);

    CalculatorService calculatorService = new CalculatorService(mockOperator, mockOutputWriter);
    calculatorService.calculate("2 + 1");

    verify(mockParser, times(1)).parse("2 + 1");
  }

  @Test
  public void service_invokes_output_writer() {

    Operator mockOperator = mock(Operator.class);
    OutputWriter mockOutputWriter = mock(OutputWriter.class);
    when(mockOperator.execute(2,3)).thenReturn(5);

    CalculatorService calculatorService = new CalculatorService(mockOperator, mockOutputWriter);
    calculatorService.calculate("2 + 3");

    verify(mockOutputWriter, times(1)).printLine("5");
  }

  @Test
  public void service_invokes_output_writer_2() {

    Operator mockOperator = mock(Operator.class);
    OutputWriter mockOutputWriter = mock(OutputWriter.class);
    when(mockOperator.execute(6,1)).thenReturn(7);

    CalculatorService calculatorService = new CalculatorService(mockOperator, mockOutputWriter);
    calculatorService.calculate("6 + 1");

    verify(mockOutputWriter, times(1)).printLine("7");
  }

}
