package org.ies.tierno.models;

import org.ies.tierno.exeptions.DivideByZeroExeption;
import org.ies.tierno.exeptions.EmptyListException;

import java.util.List;

public class Calculator {
    public double div(double numerator, double denominator) throws DivideByZeroExeption {
        if (denominator == 0) {
            throw new DivideByZeroExeption();
        }
        return numerator / denominator;
    }

    public double average(List<Double> numbers) throws EmptyListException {
//        return numbers.stream()
//                .reduce((n1, n2) -> n1 + n2)
//                .map(sum -> sum / numbers.size())
//                .orElseThrow(EmptyListException::new);
        if (numbers.isEmpty()) {
            throw new EmptyListException();
        }
        double sum = 0;
        for (var number : numbers) {
            sum += number;
        }

        return sum / numbers.size();
    }
}

