package com.codurance.calculator.operators;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class AddTest {

    @ParameterizedTest
    @CsvSource({
        "5,3,8",
        "6,4,10",
        "-4,20,16"})
    public void add_two_numbers_together(int firstNumber, int secondNumber, int expectedAnswer) {
        Add operator = new Add();

        int result = operator.execute(firstNumber, secondNumber);

        assertEquals(expectedAnswer, result);
    }

}
