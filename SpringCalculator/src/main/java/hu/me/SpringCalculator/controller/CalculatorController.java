package hu.me.SpringCalculator.controller;

import hu.me.SpringCalculator.controller.dto.InputValues;
import hu.me.SpringCalculator.exceptions.DivisionByZeroException;
import hu.me.SpringCalculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(path = "/calculator")
public class CalculatorController {

    CalculatorService calculatorService;

    @Autowired
    public void setCalculatorService(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @RequestMapping(method = RequestMethod.GET)
    ModelAndView first() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("index");
        modelAndView.addObject("inputValues", new InputValues("+",
                0.0, 0.0));
        modelAndView.addObject("result", 0);
        modelAndView.addObject("details", "There are no details yet.");

        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    ModelAndView post(@Valid InputValues inputValues, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();

        if(bindingResult.hasErrors()) {
            modelAndView.setViewName("index");
        } else {
            try {
                modelAndView.addObject("result", calculatorService.calculate(inputValues));
            } catch (DivisionByZeroException ex) {
                bindingResult.addError(new FieldError("inputValues", "operand2",
                        "Nullaval nem lehet osztani"));
                modelAndView.addObject("details", calculatorService.getDetails());
                modelAndView.setViewName("index");
                return modelAndView;
            }

            calculatorService.details("{" + inputValues.getOperand1() + " " + inputValues.getOperator() +
                    " " + inputValues.getOperand2() + " = "
                    + modelAndView.getModel().values().toString().replace("[", "").replace("" +
                    "]", "") + "}");
            modelAndView.addObject("details", calculatorService.getDetails());
            modelAndView.setViewName("index");
        }
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/details")
    @ResponseBody
    public List details() {
        return calculatorService.getDetails();
    }



}
