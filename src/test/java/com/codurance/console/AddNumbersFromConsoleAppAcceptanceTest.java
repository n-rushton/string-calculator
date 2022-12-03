package com.codurance.console;

import com.codurance.calculator.CalculatorService;
import com.codurance.calculator.operators.Add;
import com.codurance.calculator.parsers.TwoOperandParser;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import static org.mockito.Mockito.*;

public class AddNumbersFromConsoleAppAcceptanceTest {

    @Test
    public void add_two_numbers_from_console_app() throws IOException {
        OutputWriter mockOutputWriter = mock(OutputWriter.class);
        BufferedReader mockScanner = mock(BufferedReader.class);
        when(mockScanner.readLine()).thenReturn("1+ 7");

        new CalculatorApp(
                mockOutputWriter,
                mockScanner,
                new CalculatorService(new TwoOperandParser(List.of(new Add())))
            ).run();

        verify(mockOutputWriter, times(1)).printLine("enter calculation:");
        verify(mockOutputWriter, times(1)).printLine("8");
    }

}
