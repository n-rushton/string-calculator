package com.codurance.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.codurance.calculator.operators.Operator;
import com.codurance.calculator.parsers.Equation;
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
    calculatorService = new CalculatorService(
            mockParser);
  }

  @Test
  public void service_invokes_operator() {
    when(mockParser.parseExpression("1 + 2"))
            .thenReturn(new Equation(mockAdditionOperator, List.of(1, 2)));

    calculatorService.calculate("1 + 2");

    verify(mockAdditionOperator, times(1)).execute(1, 2);
  }

  @Test
  public void service_invokes_parser() {
    when(mockParser.parseExpression("2 + 1"))
            .thenReturn(new Equation(mockAdditionOperator, List.of(2, 1)));

    calculatorService.calculate("2 + 1");

    verify(mockParser, times(1)).parseExpression("2 + 1");
  }

  @Test
  public void service_return_result_of_2_add_3() {
    when(mockParser.parseExpression("2 + 3"))
            .thenReturn(new Equation(mockAdditionOperator, List.of(2, 3)));
    when(mockAdditionOperator.execute(2,3)).thenReturn(5);

    int result = calculatorService.calculate("2 + 3");

    assertEquals(5, result);
  }

  @Test
  public void service_return_result_of_6_add_1() {
    when(mockParser.parseExpression("6 + 1"))
            .thenReturn(new Equation(mockAdditionOperator, List.of(6, 1)));
    when(mockAdditionOperator.execute(6, 1)).thenReturn(7);

    int result = calculatorService.calculate("6 + 1");

    assertEquals(7, result);
  }

}
