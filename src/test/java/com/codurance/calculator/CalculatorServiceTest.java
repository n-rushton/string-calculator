package com.codurance.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.codurance.calculator.operators.Operator;
import com.codurance.calculator.parsers.EquationParser;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorServiceTest {

  Operator mockAdditionOperator;
  EquationParser mockParser;
  CalculatorService calculatorService;


  @BeforeEach
  void setUp() {
    mockAdditionOperator = mock(Operator.class);
    when(mockAdditionOperator.getSymbol()).thenReturn("+");
    mockParser = mock(EquationParser.class);
    calculatorService = new CalculatorService(mockAdditionOperator,
            mockParser);
  }

  @Test
  public void service_invokes_operator() {
    when(mockParser.parse("1 + 2")).thenReturn(List.of(1, 2));

    calculatorService.calculate("1 + 2");

    verify(mockAdditionOperator, times(1)).execute(1, 2);
  }

  @Test
  public void service_invokes_parser() {
    when(mockParser.parse("2 + 1")).thenReturn(List.of(2, 1));

    calculatorService.calculate("2 + 1");

    verify(mockParser, times(1)).parse("2 + 1");
  }

  @Test
  public void service_return_result_of_2_add_3() {
    when(mockParser.parse("2 + 3")).thenReturn(List.of(2, 3));
    when(mockAdditionOperator.execute(2,3)).thenReturn(5);

    int result = calculatorService.calculate("2 + 3");

    assertEquals(5, result);
  }

  @Test
  public void service_return_result_of_6_add_1() {
    when(mockParser.parse("6 + 1")).thenReturn(List.of(6, 1));
    when(mockAdditionOperator.execute(6, 1)).thenReturn(7);

    int result = calculatorService.calculate("6 + 1");

    assertEquals(7, result);
  }

  @Test
  public void service_invokes_correct_operator() {
    Operator usedOperator = mock(Operator.class);
    Operator notUsedOperator = mock(Operator.class);
    when(mockParser.parse("8 + 3")).thenReturn(List.of(8, 3));
    when(usedOperator.getSymbol()).thenReturn("+");
    when(notUsedOperator.getSymbol()).thenReturn("-");

    CalculatorService calculatorService = new CalculatorService(List.of(notUsedOperator, usedOperator), mockParser);
    calculatorService.calculate("8 + 3");

    verify(usedOperator, times(1)).execute(8,3);
    verify(notUsedOperator, never()).execute(8,3);
  }

}
