/*
package hu.me;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class UserTest
{
    public List<Checker> checkers;
    public UserController userController;
    public ValidatorResponse validatorResponse;

    @Before
    public void init() {
        checkers = new ArrayList<>();
        checkers.add(new EmptyValidator());
        checkers.add(new NoSpaceValidator());
        checkers.add(new PasswordLengthValidator());
        checkers.add(new UsernameLengthValidator());
    }

    @Test
    public void checkEmptyUser() {
        User user = new User("", "");


        List<ValidatorResponse> errors = new LinkedList<>();
        for (Checker checker : checkers) {
            ValidatorResponse response = checker.valid(user);
            if (!response.isValid())
                errors.add(response);
        }
        if (!errors.isEmpty()) {
            System.out.println("Number of errors: " + errors.size());
            errors.forEach(error -> System.out.println(error.getMessage()));

        } else {

        }

        Assert.assertEquals("Ures felhasznalonev",validatorResponse.getMessage());

    }
}
*/