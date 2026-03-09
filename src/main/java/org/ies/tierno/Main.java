package org.ies.tierno;

import org.ies.tierno.app.CalculatorApp;
import org.ies.tierno.exeptions.DivideByZeroExeption;
import org.ies.tierno.models.Calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws DivideByZeroExeption {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        CalculatorApp app = new CalculatorApp(calculator, scanner);

        app.run();
    }
}