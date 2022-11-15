package com.codurance;

import java.util.Arrays;

public class Add implements Operator {
    @Override
    public int execute(int... operands) {
        return Arrays.stream(operands).sum();
    }
}