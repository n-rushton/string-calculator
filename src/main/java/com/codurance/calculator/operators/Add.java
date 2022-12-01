package com.codurance.calculator.operators;

import java.util.Arrays;

public class Add implements Operator {
    @Override
    public int execute(int... operands) {
        return Arrays.stream(operands).sum();
    }

    @Override
    public CharSequence getSymbol() {
        return "+";
    }
}