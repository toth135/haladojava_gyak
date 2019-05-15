package hu.me.SpringCalculator.service;

import hu.me.SpringCalculator.controller.dto.InputValues;
import hu.me.SpringCalculator.entity.InputEntity;
import hu.me.SpringCalculator.entity.User;
import hu.me.SpringCalculator.exceptions.DivisionByZeroException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CalculatorService {

    double calculate(InputValues inputValues, Boolean save);

    void save(InputEntity inputEntity);

    List<String> getLog();

    Iterable<InputEntity> getDetails();

    Iterable<User> getUsers();

    List<String> details(String detail);

    List<String> getDetailsWithUser(Long userId);

    Iterable<User> getUserByUsername(String username);

}
