package com.codurance.console;

import com.codurance.calculator.CalculatorService;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class CalculatorAppTest {

    OutputWriter mockOutputWriter = mock(OutputWriter.class);
    BufferedReader mockScanner = mock(BufferedReader.class);
    CalculatorService mockCalculatorService = mock(CalculatorService.class);

    @Test public void display_enter_calculation_prompt() {
        new CalculatorApp(mockOutputWriter, mockScanner, mockCalculatorService).run();

        verify(mockOutputWriter, times(1)).printLine("enter calculation:");
    }

    @Test public void read_input_calculation() throws IOException {
        new CalculatorApp(mockOutputWriter, mockScanner, mockCalculatorService).run();

        verify(mockScanner, times(1)).readLine();
    }

    @Test public void calculate_result() throws IOException {
        when(mockScanner.readLine()).thenReturn("1+ 4");
        new CalculatorApp(mockOutputWriter, mockScanner, mockCalculatorService).run();

        verify(mockCalculatorService, times(1)).calculate("1+ 4");
    }

    @Test public void output_result() throws IOException {
        when(mockCalculatorService.calculate(null)).thenReturn(5);
        new CalculatorApp(mockOutputWriter, mockScanner, mockCalculatorService).run();

        verify(mockOutputWriter, times(1)).printLine("5");
    }
}
