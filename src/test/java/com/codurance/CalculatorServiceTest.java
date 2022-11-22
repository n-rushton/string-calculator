package com.codurance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorServiceTest {

  Operator mockOperator;
  EquationParser mockParser;
  CalculatorService calculatorService;


  @BeforeEach
  void setUp() {
    mockOperator = mock(Operator.class);
    mockParser = mock(EquationParser.class);
    calculatorService = new CalculatorService(mockOperator,
            mockParser);
  }

  @Test
  public void service_invokes_operator() {
    when(mockParser.parse("1 + 2")).thenReturn(List.of(1, 2));

    calculatorService.calculate("1 + 2");

    verify(mockOperator, times(1)).execute(1, 2);
  }

  @Test
  public void service_invokes_parser() {
    when(mockParser.parse("2 + 1")).thenReturn(List.of(2, 1));

    calculatorService.calculate("2 + 1");

    verify(mockParser, times(1)).parse("2 + 1");
  }

  @Test
  public void service_invokes_output_writer() {
    when(mockParser.parse("2 + 3")).thenReturn(List.of(2, 3));
    when(mockOperator.execute(2,3)).thenReturn(5);

    int result = calculatorService.calculate("2 + 3");

    assertEquals(5, result);
  }

  @Test
  public void service_invokes_output_writer_2() {
    when(mockParser.parse("6 + 1")).thenReturn(List.of(6, 1));
    when(mockOperator.execute(6, 1)).thenReturn(7);

    int result = calculatorService.calculate("6 + 1");

    assertEquals(7, result);
  }

}
