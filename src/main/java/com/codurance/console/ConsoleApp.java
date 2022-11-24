package com.codurance.console;

import com.codurance.calculator.CalculatorService;
import com.codurance.calculator.operators.Add;
import com.codurance.calculator.parsers.TwoOperandParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConsoleApp {
    public static void main(String[] args) {
        new CalculatorApp(
            new ConsoleOutputWriter(),
            new BufferedReader(new InputStreamReader(System.in)),
            new CalculatorService(new Add(), new TwoOperandParser()))
            .run();
    }
}

