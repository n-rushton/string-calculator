package com.codurance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddTest {

    @Test
    public void add_two_positive_numbers_together() {
        int firstNumber = 5;
        int secondNumber = 3;
        int expectedAnswer = 8;
        Add operator = new Add();

        int result = operator.execute(firstNumber, secondNumber);

        assertEquals(expectedAnswer, result);
    }
}
