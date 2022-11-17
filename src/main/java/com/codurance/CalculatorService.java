package com.codurance;

import java.util.List;

public class CalculatorService {

  private final Operator operator;
  private final OutputWriter outputWriter;
  private final EquationParser parser;

  public CalculatorService(Operator operator, OutputWriter outputWriter, EquationParser parser) {
    this.operator = operator;
    this.outputWriter = outputWriter;
    this.parser = parser;
  }

  public void calculate(String s) {
    List<Integer> operands = parser.parse(s);

    int result = operator.execute(operands.get(0), operands.get(1));
    outputWriter.printLine(String.valueOf(result));
  }
}
