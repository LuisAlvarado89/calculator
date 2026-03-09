package org.ies.tierno.app;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.ies.tierno.exeptions.DivideByZeroExeption;
import org.ies.tierno.exeptions.EmptyListException;
import org.ies.tierno.models.Calculator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
@Log4j
public class CalculatorApp {
    private final Calculator calculator;
    private final Scanner scanner;

    public void run() throws DivideByZeroExeption {
        int opt;
        do {
            log.info("Elige una opción:");
            log.info("1. Media");
            log.info("2. División");
            log.info("3. Salir");
            opt = scanner.nextInt();
            scanner.nextLine();

            if (opt == 1) {
                runAverageOpt();
            } else if (opt == 2) {
                runDivOpt();
            }
        } while (opt != 3);

    }

    private void runDivOpt() throws DivideByZeroExeption {
        log.info("Introduce el numerador");
        double numerator = scanner.nextDouble();
        scanner.nextLine();

        log.info("Introduce el denominador");
        double denominator = scanner.nextDouble();
        scanner.nextLine();

        log.info(calculator.div(numerator, denominator));
    }

    private void runAverageOpt() {
        List<Double> numbers = new ArrayList<>();
        String resp;
        do {
            log.info("¿Vas a introducir más números? (S/n)");
            resp = scanner.nextLine();
            if (!resp.equalsIgnoreCase("N")) {
                log.info("Introduce el número");
                numbers.add(scanner.nextDouble());
                scanner.nextLine();
            }
        } while (!resp.equalsIgnoreCase("N"));

        try {
            log.info(calculator.average(numbers));
        } catch (EmptyListException e) {
            log.error("No se puede calcular la media de una lista vacía");
        }
    }
}