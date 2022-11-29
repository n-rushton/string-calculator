package com.codurance.calculator.operators;

public class Subtract implements Operator {

  @Override
  public int execute(int... operands) {
    return operands[0] - operands[1];
  }

}
