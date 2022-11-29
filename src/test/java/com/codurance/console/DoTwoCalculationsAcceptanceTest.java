package com.codurance.console;

import com.codurance.calculator.CalculatorService;
import com.codurance.calculator.operators.Add;
import com.codurance.calculator.operators.Subtract;
import com.codurance.calculator.parsers.TwoOperandParser;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import static org.mockito.Mockito.*;

public class DoTwoCalculationsAcceptanceTest {

    @Test
    public void do_two_calcualtions() throws IOException {
        OutputWriter mockOutputWriter = mock(OutputWriter.class);
        BufferedReader mockScanner = mock(BufferedReader.class);

        CalculatorService calculatorService = new CalculatorService(
                                                    List.of(new Add(), new Subtract()),
                                                    new TwoOperandParser());
        CalculatorApp calculatorApp = new CalculatorApp(
                                                mockOutputWriter,
                                                mockScanner,
                                                calculatorService);

        when(mockScanner.readLine()).thenReturn("4 + 3");
        calculatorApp.run();
        verify(mockOutputWriter, times(1)).printLine("7");

        when(mockScanner.readLine()).thenReturn("8- 3");
        calculatorApp.run();
        verify(mockOutputWriter, times(1)).printLine("5");
    }

}
