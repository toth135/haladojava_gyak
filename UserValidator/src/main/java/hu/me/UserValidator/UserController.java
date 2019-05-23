package hu.me.UserValidator;

import java.util.ArrayList;
import java.util.List;

public class UserController {

    private final UserService userService;
    private final List<Checker> checkers;

    public UserController(UserService userService, List<Checker> checkers) {
        this.userService = userService;
        this.checkers = checkers;
    }

    public boolean validUser(User user) {
        if (checkers == null) {
            return true;
        }
        List<ValidatorResponse> errors = new ArrayList<>();
        for (Checker checker : checkers) {
            ValidatorResponse response = checker.valid(user);
            if (!response.isValid())
                errors.add(response);
        }
        if (!errors.isEmpty()) {
            System.out.println("Hibák száma: " + errors.size());
            errors.forEach(error -> System.out.println(error.getMessage()));
            return false;
        } else {
            return true;
        }
    }

    public void createUser(String username, String password) {
        User user = new User(username, password);
        if (validUser(user))
            userService.saveUser(user);
    }

}
