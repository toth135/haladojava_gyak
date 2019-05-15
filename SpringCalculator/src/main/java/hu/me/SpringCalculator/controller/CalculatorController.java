package hu.me.SpringCalculator.controller;

import hu.me.SpringCalculator.controller.dto.InputValues;
import hu.me.SpringCalculator.entity.InputEntity;
import hu.me.SpringCalculator.entity.User;
import hu.me.SpringCalculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CalculatorController {

    CalculatorService calculatorService;

    @Autowired
    public void setCalculatorService(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @ModelAttribute("operator")
    public List<String> operations() {
        List<String> operations = new ArrayList<>();
        operations.add("+");
        operations.add("-");
        operations.add("*");
        operations.add("/");
        return operations;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView initialize(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("inputValues", new InputValues("", 0D, 0D, 0L, "",0));
        modelAndView.addObject("result", 0);
        modelAndView.addObject("details");
        modelAndView.addObject("userDetails");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView post(@Valid InputValues inputValues, BindingResult bindingResult) {

        System.out.println(inputValues);
        System.out.println(bindingResult);

        ModelAndView modelAndView = new ModelAndView();

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("index");
        } else {
            modelAndView.addObject("result", calculatorService.calculate(inputValues, true));
            calculatorService.details("{" + inputValues.getOperand1() +
                    " " + inputValues.getOperator() +
                    " " + inputValues.getOperand2() +
                    " = " + calculatorService.calculate(inputValues, false) +
                    " , " + inputValues.getUserId() +
                    " , " + inputValues.getUsername() +
                    " , " + inputValues.getAge() +
                    "}"
            );

            modelAndView.addObject("details", calculatorService.getLog());
            modelAndView.addObject("userDetails", calculatorService.getDetailsWithUser(inputValues.getUserId()));
            modelAndView.addObject("inputValues", new InputValues("", 0D, 0D, 0L, "",0));

            modelAndView.setViewName("index");
        }
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/details")
    @ResponseBody
    public List<String> details() {
        return calculatorService.getLog();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/listCalculations")
    @ResponseBody
    public Iterable<InputEntity> listCalculations() {
        return calculatorService.getDetails();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/listUsers")
    @ResponseBody
    public Iterable<User> listUsers() {
        return calculatorService.getUsers();
    }

    @GetMapping("/getUsername/{username}")
    public Iterable<User> getUserByUsername(@PathVariable String username) {
      return calculatorService.getUserByUsername(username);
    }

}

