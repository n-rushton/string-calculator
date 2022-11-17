package com.codurance;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TwoOperandParserTest {

    @Test
    public void extract_two_numbers_from_string() {
        List<Integer> expectedList = List.of(8,4);
        TwoOperandParser parser = new TwoOperandParser();

        List<Integer> resultantList = parser.parse("8 + 4");

        assertEquals(expectedList, resultantList);
    }

}
