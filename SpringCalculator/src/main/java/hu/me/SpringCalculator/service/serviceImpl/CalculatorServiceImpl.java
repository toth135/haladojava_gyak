package hu.me.SpringCalculator.service.serviceImpl;

import hu.me.SpringCalculator.controller.dto.InputValues;
import hu.me.SpringCalculator.dao.CalculatorRepository;
import hu.me.SpringCalculator.dao.UserRepository;
import hu.me.SpringCalculator.entity.InputEntity;
import hu.me.SpringCalculator.entity.User;
import hu.me.SpringCalculator.service.Calculator;
import hu.me.SpringCalculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    Calculator calculator;
    private List<String> details = new ArrayList();

    CalculatorRepository calculatorRepository;
    UserRepository userRepository;

    @Autowired
    public void setCalculatorRepository(CalculatorRepository calculatorRepository) {
        this.calculatorRepository = calculatorRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    @Autowired
    public CalculatorServiceImpl(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public double calculate(InputValues inputValues, Boolean save) {
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
                if(inputValues.getOperand2() == 0.0)
                result = calculator.divide(inputValues.getOperand1(), inputValues.getOperand2());
                break;
        }
        if (save) {
            calculatorRepository.save(new InputEntity(inputValues.getOperator(), inputValues.getOperand1(), inputValues.getOperand2(), result, inputValues.getUserId()));
            userRepository.save(new User(inputValues.getUserId(), inputValues.getUsername(), inputValues.getAge()));
            return result;
        } else {
            return result;
        }
    }

    @Override
    public void save(InputEntity inputEntity){
        calculatorRepository.save(inputEntity);
    }

    @Override
    public List<String> details(String detail) {
        details.add(detail);
        return details;
    }

    @Override
    public List<String> getLog(){
        return details;
    }

    @Override
    public Iterable<InputEntity> getDetails() {
        return calculatorRepository.findAll();
    }

    @Override
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<String> getDetailsWithUser(Long userId) {
        Iterable<InputEntity> inputEntities = calculatorRepository.findAll();
        Iterable<User> users = userRepository.findAll();
        List<String> details = new ArrayList<>();

        for (InputEntity inputEntity : inputEntities) {
            for (User user : users) {
                if(inputEntity.getUserId() == user.getUserId() && user.getUserId() == userId) {
                    details.add("userId: " + inputEntity.getUserId() + ", " +
                            "username: " + user.getUsername() + ", " +
                            "age: " + user.getAge() + ", " +
                            "calculation: " + inputEntity.getOperand1() +
                            " " + inputEntity.getOperator() +
                            " " + inputEntity.getOperand2() +
                            " = " + inputEntity.getResult()
                    );
                }
            }
        }
        return details;
    }

    @Override
    public Iterable<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
