package com.codurance.calculator.parsers;

import com.codurance.calculator.operators.Operator;

import java.util.List;
import java.util.Objects;

public class TwoOperandEquation extends Equation {

    private Operator operator;
    private List<Integer> operands;

    public TwoOperandEquation(Operator operator, List<Integer> operands) {
        this.operator = operator;
        this.operands = operands;
    }

    @Override
    public int execute() {
      return operator.execute(operands.get(0), operands.get(1));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TwoOperandEquation equation = (TwoOperandEquation) o;
        return operator.equals(equation.operator) && operands.equals(equation.operands);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operator, operands);
    }

}
