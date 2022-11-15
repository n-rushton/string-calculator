package com.codurance;

public class CalculatorService {

  private final Operator operator;
  private OutputWriter outputWriter;

  public CalculatorService(Operator operator, OutputWriter outputWriter) {
    this.operator = operator;
    this.outputWriter = outputWriter;
  }

  public void calculate(String s) {
    int result = operator.execute(1, 2);
    outputWriter.printLine(String.valueOf(result));
  }
}
