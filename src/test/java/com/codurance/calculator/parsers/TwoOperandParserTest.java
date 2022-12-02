package com.codurance.calculator.parsers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Stream;

import com.codurance.calculator.operators.Add;
import com.codurance.calculator.operators.Operator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TwoOperandParserTest {

    @ParameterizedTest
    @MethodSource("generateAdditionEquations")
    public void extract_two_numbers_from_addition_equation(String equation, List<Integer> expectedList) {
        TwoOperandParser parser = new TwoOperandParser();

        List<Integer> resultantList = parser.parse(equation);

        assertEquals(expectedList, resultantList);
    }

    static Stream<Arguments> generateAdditionEquations() {
        return Stream.of(
            Arguments.of("8 + 4", List.of(8, 4)),
            Arguments.of("18 + 4", List.of(18, 4)),
            Arguments.of("182 + 4", List.of(182, 4)),
            Arguments.of("1825 + 4", List.of(1825, 4)),
            Arguments.of("8 + 42", List.of(8, 42)),
            Arguments.of("168 + 428964", List.of(168, 428964)),
            Arguments.of("168+ 428964", List.of(168, 428964)),
            Arguments.of("168 +428964", List.of(168, 428964)),
            Arguments.of("168+428964", List.of(168, 428964)),
            Arguments.of("-2 + -10", List.of(-2, -10))
        );
    }

    @ParameterizedTest
    @MethodSource("generateSubtractionEquations")
    public void extract_two_numbers_from_subtraction_equation(String equation, List<Integer> expectedList) {
        TwoOperandParser parser = new TwoOperandParser();

        List<Integer> resultantList = parser.parse(equation);

        assertEquals(expectedList, resultantList);
    }

    static Stream<Arguments> generateSubtractionEquations() {
        return Stream.of(
            Arguments.of("25 - 5", List.of(25, 5)),
            Arguments.of("-25 - 5", List.of(-25, 5)),
            Arguments.of("25 - -5", List.of(25, -5))
        );
    }

    @Test
    public void extract_equation_from_expression() {
        Operator operator = mock(Operator.class);
        when(operator.getSymbol()).thenReturn("+");
        Equation expectedEquation = new Equation(operator, List.of(23,75));
        EquationParser parser = new TwoOperandParser(List.of(operator));

        Equation resultantEquation = parser.parseExpression("23 + 75");

        assertEquals(expectedEquation, resultantEquation);
    }

    @Test
    public void extract_correct_operand_for_equation_from_expression() {
        Operator operatorToUse = mock(Operator.class);
        when(operatorToUse.getSymbol()).thenReturn("-");
        Operator dontUseOperator = mock(Operator.class);
        when(dontUseOperator.getSymbol()).thenReturn("/");

        Equation expectedEquation = new Equation(operatorToUse, List.of(53,97));
        EquationParser parser = new TwoOperandParser(List.of(dontUseOperator, operatorToUse));

        Equation resultantEquation = parser.parseExpression("53 - 97");

        assertEquals(expectedEquation, resultantEquation);
    }

}
