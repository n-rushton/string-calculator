package com.codurance.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.codurance.calculator.operators.Add;
import com.codurance.calculator.operators.Operator;
import com.codurance.calculator.operators.Subtract;
import com.codurance.calculator.parsers.EquationParser;
import com.codurance.calculator.parsers.TwoOperandParser;
import org.junit.jupiter.api.Test;

public class CalculatorServiceAcceptanceTest {

  @Test public void add_two_numbers_together() {
    EquationParser parser = new TwoOperandParser();
    Operator additionOperator = new Add();
    CalculatorService calculatorService = new CalculatorService(additionOperator, parser);

    int result = calculatorService.calculate("1564 + 36574");

    assertEquals(38138, result);
  }

  @Test public void subtract_two_numbers() {
    EquationParser parser = new TwoOperandParser();
    Operator subtractionOperator = new Subtract();
    CalculatorService calculatorService = new CalculatorService(subtractionOperator, parser);

    int result = calculatorService.calculate("2500 - 12");

    assertEquals(2488, result);
  }

}
