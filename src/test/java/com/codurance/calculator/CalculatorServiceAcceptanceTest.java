package com.codurance.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.codurance.calculator.operators.Add;
import com.codurance.calculator.operators.Operator;
import com.codurance.calculator.operators.Subtract;
import com.codurance.calculator.parsers.EquationParser;
import com.codurance.calculator.parsers.TwoOperandParser;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CalculatorServiceAcceptanceTest {

  @Test public void add_two_numbers_together() {
    Operator additionOperator = new Add();
    EquationParser parser = new TwoOperandParser(List.of(additionOperator));
    CalculatorService calculatorService = new CalculatorService(additionOperator, parser);

    int result = calculatorService.calculate("1564 + 36574");

    assertEquals(38138, result);
  }

  @Test public void subtract_two_numbers() {
    Operator subtractionOperator = new Subtract();
    EquationParser parser = new TwoOperandParser(List.of(subtractionOperator));
    CalculatorService calculatorService = new CalculatorService(subtractionOperator, parser);

    int result = calculatorService.calculate("2500 - -12");

    assertEquals(2512, result);
  }

}
