package hu.me.SpringCalculator.service;

import hu.me.SpringCalculator.controller.dto.InputValues;

import java.util.List;

public interface CalculatorService {

    double calculate(InputValues inputValues);


    List details(String detail);

    List getDetails();
}
