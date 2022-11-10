package com.codurance;

public class CalculatorService {

  private final Operator operator;

  public CalculatorService(Operator operator) {
    this.operator = operator;
  }

  public void calculate(String s) {
    operator.execute(1, 2);
  }
}
