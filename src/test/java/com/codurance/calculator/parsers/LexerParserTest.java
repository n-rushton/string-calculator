package com.codurance.calculator.parsers;

import com.codurance.calculator.lexer.Lexer;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LexerParserTest {

    @Test
    public void given_input_string_retrieve_lexer_tokens() {
        String inputString = "12 + 14";
        Lexer mockLexer = mock(Lexer.class);

        LexerParser parser = new LexerParser(mockLexer);
        parser.parseExpression(inputString);

        verify(mockLexer).lex(inputString);
    }

}
