package hu.me.SpringCalculator.service.serviceImpl;

import hu.me.SpringCalculator.service.Calculator;
import org.springframework.stereotype.Service;

@Service
public class CalculatorImpl implements Calculator {

    @Override
    public double add(double a, double b) {
        return a + b;
    }

    @Override
    public double subtract(double a, double b) {
        return a - b;
    }

    @Override
    public double multiply(double a, double b) {
        return a * b;
    }

    @Override
    public double divide(double a, double b){

        return a / b;
    }
}
