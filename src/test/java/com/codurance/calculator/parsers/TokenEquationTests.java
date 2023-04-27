package com.codurance.calculator.parsers;

import com.codurance.calculator.lexer.LexerToken;
import com.codurance.calculator.lexer.TokenType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TokenEquationTests {

    @ParameterizedTest
    @MethodSource("generateAdditionEquations")
    public void add_two_numbers_together(List<LexerToken> tokens, int expectedResult) {
        Equation equation = new TokenEquation(tokens);

        int result = equation.execute();

        assertEquals(expectedResult, result);
    }

    static Stream<Arguments> generateAdditionEquations() {
        return Stream.of(
                Arguments.of(List.of(
                    new LexerToken(TokenType.NUMBER, "87", 0),
                    new LexerToken(TokenType.ADDITION, "+", 2),
                    new LexerToken(TokenType.NUMBER, "5", 3)
                ), 92),
                Arguments.of(List.of(
                        new LexerToken(TokenType.NUMBER, "2", 0),
                        new LexerToken(TokenType.ADDITION, "+", 1),
                        new LexerToken(TokenType.NUMBER, "2", 2)
                ), 4)
        );
    }

}
