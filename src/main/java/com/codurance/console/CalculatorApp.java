package com.codurance.console;

import com.codurance.calculator.CalculatorService;

import java.io.BufferedReader;
import java.io.IOException;

public class CalculatorApp {

    private final OutputWriter outputWriter;
    private final BufferedReader inputScanner;
    private final CalculatorService calculatorService;

    CalculatorApp(OutputWriter outputWriter, BufferedReader inputScanner, CalculatorService calculatorService) {
        this.outputWriter = outputWriter;
        this.inputScanner = inputScanner;
        this.calculatorService = calculatorService;
    }

    void run() {
        try {

            outputWriter.printLine("enter calculation:");
            String input = inputScanner.readLine();
            int result = calculatorService.calculate(input);
            outputWriter.printLine(String.valueOf(result));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
