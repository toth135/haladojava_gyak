package hu.me.SpringCalculator.service;

import hu.me.SpringCalculator.controller.dto.InputValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    Calculator calculator;
    private List details = new ArrayList();

    @Autowired
    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    public CalculatorServiceImpl(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public double calculate(InputValues inputValues) {
        double result = 0;
        switch (inputValues.getOperator()) {
            case "+":
                result = calculator.add(inputValues.getOperand1(), inputValues.getOperand2());
                break;
            case "-":
                result = calculator.subtract(inputValues.getOperand1(), inputValues.getOperand2());
                break;
            case "*":
                result = calculator.multiply(inputValues.getOperand1(), inputValues.getOperand2());
                break;
            case "/":
                result = calculator.divide(inputValues.getOperand1(), inputValues.getOperand2());
                break;
        }
        return result;
    }

    @Override
    public List details(String detail) {
        details.add(detail);
        return details;
    }
    @Override
    public List getDetails() {
        return details;
    }

}
