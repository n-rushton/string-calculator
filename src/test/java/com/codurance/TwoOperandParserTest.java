package com.codurance;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TwoOperandParserTest {

    @ParameterizedTest
    @MethodSource("generateEquations")
    public void extract_two_numbers_from_string(String equation, List<Integer> expectedList) {
        TwoOperandParser parser = new TwoOperandParser();

        List<Integer> resultantList = parser.parse(equation);

        assertEquals(expectedList, resultantList);
    }

    static Stream<Arguments> generateEquations() {
        return Stream.of(
            Arguments.of("8 + 4", List.of(8, 4)),
            Arguments.of("18 + 4", List.of(18, 4)),
            Arguments.of("182 + 4", List.of(182, 4)),
            Arguments.of("1825 + 4", List.of(1825, 4)));
    }

}
