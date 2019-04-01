package hu.me.SpringCalculator.service;

import hu.me.SpringCalculator.controller.dto.InputValues;
import hu.me.SpringCalculator.exceptions.DivisionByZeroException;

import java.util.List;

public interface CalculatorService {

    double calculate(InputValues inputValues) throws DivisionByZeroException;

    List details(String detail);

    List getDetails();
}
