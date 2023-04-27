package com.codurance.calculator.parsers;

import com.codurance.calculator.lexer.Lexer;
import com.codurance.calculator.lexer.LexerToken;
import com.codurance.calculator.lexer.TokenType;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class LexerParserTest {

    @Test
    public void given_input_string_retrieve_lexer_tokens() {
        String inputString = "12 + 14";
        Lexer mockLexer = mock(Lexer.class);

        LexerParser parser = new LexerParser(mockLexer);
        parser.parseExpression(inputString);

        verify(mockLexer).lex(inputString);
    }

    @Test
    public void given_lexer_returns_lexer_token_returns_equation() {

        String inputString = "12+14";
        Lexer mockLexer = mock(Lexer.class);
        LexerParser parser = new LexerParser(mockLexer);
        List<LexerToken> lexerTokens = List.of(new LexerToken(TokenType.NUMBER, "12", 0), new LexerToken(TokenType.ADDITION, "+", 2), new LexerToken(TokenType.NUMBER, "14", 3));
        when(mockLexer.lex(anyString())).thenReturn(lexerTokens);

        Equation result = parser.parseExpression(inputString);
        Equation expectedEquation = new TokenEquation(lexerTokens);

        assertEquals(expectedEquation, result);
    }
}
