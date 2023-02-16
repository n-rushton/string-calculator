package com.codurance.calculator.lexer;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LexerTest {

    @ParameterizedTest
    @MethodSource("generateLexInput")
    void extract(String equation, List<LexerToken> expectedList) {
        List<LexerToken> result = new Lexer().lex(equation);

        assertEquals(expectedList, result);
    }

    static Stream<Arguments> generateLexInput() {
        return Stream.of(
                Arguments.of(" ", List.of(new LexerToken(TokenType.WHITESPACE, " ", 0))),
                Arguments.of("1", List.of(new LexerToken(TokenType.NUMBER, "1", 0))),
                Arguments.of("2", List.of(new LexerToken(TokenType.NUMBER, "2", 0))),
                Arguments.of("10", List.of(new LexerToken(TokenType.NUMBER, "10", 0))),
                Arguments.of("1050 ", List.of(
                        new LexerToken(TokenType.NUMBER, "1050", 0),
                        new LexerToken(TokenType.WHITESPACE, " ", 4))),
                Arguments.of("1234 ", List.of(
                        new LexerToken(TokenType.NUMBER, "1234", 0),
                        new LexerToken(TokenType.WHITESPACE, " ", 4))),
                Arguments.of("81 ", List.of(
                        new LexerToken(TokenType.NUMBER, "81", 0),
                        new LexerToken(TokenType.WHITESPACE, " ", 2))),
                Arguments.of(" 81", List.of(
                    new LexerToken(TokenType.WHITESPACE, " ", 0),
                    new LexerToken(TokenType.NUMBER, "81", 1))),
                Arguments.of(" 81 ", List.of(
                        new LexerToken(TokenType.WHITESPACE, " ", 0),
                        new LexerToken(TokenType.NUMBER, "81", 1),
                        new LexerToken(TokenType.WHITESPACE, " ", 3))),
                Arguments.of("2 34", List.of(
                        new LexerToken(TokenType.NUMBER, "2", 0),
                        new LexerToken(TokenType.WHITESPACE, " ", 1),
                        new LexerToken(TokenType.NUMBER, "34", 2))),
                Arguments.of("101 22", List.of(
                        new LexerToken(TokenType.NUMBER, "101", 0),
                        new LexerToken(TokenType.WHITESPACE, " ", 3),
                        new LexerToken(TokenType.NUMBER, "22", 4))),
                Arguments.of("101 22 ", List.of(
                    new LexerToken(TokenType.NUMBER, "101", 0),
                    new LexerToken(TokenType.WHITESPACE, " ", 3),
                    new LexerToken(TokenType.NUMBER, "22", 4),
                    new LexerToken(TokenType.WHITESPACE, " ", 6)))
        );
    }
}

