package hu.me;

import java.util.LinkedList;
import java.util.List;

public class UserController {

    private final UserService userService;
    private final List<Checker> checkers;

    public UserController(UserService userService, List<Checker> checkers) {
        this.userService = userService;
        this.checkers = checkers;
    }

    private boolean validUser(User user) {
        List<ValidatorResponse> errors = new LinkedList<>();
        for (Checker checker : checkers) {
            ValidatorResponse response = checker.valid(user);
            if (!response.isValid())
                errors.add(response);
        }
        if (errors.size() > 0) {
            System.out.println("Number of errors: " + errors.size());
            errors.forEach(error -> System.out.println(error.getMessage()));
            return false;
        } else {
            return true;
        }
    }

    public void createUser(String username, String password) {
        User user = new User(username, password);
        if(checkers == null) {
            userService.saveUser(user);
            return ;
        }
        if(validUser(user))
            userService.saveUser(user);
    }
}

//A validátort kapott paraméterrel hívták-e userregisztrálásnál, vagy usertípusú-e (tesztírás)
