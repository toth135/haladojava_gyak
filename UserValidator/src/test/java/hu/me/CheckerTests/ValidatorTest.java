package hu.me.CheckerTests;

import hu.me.UserValidator.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;

public class ValidatorTest {

    private User user;
    private List<User> userArray = new ArrayList<>();
    private PasswordValidator passwordValidator;
    private UsernameValidator usernameValidator;
    private UserController userController;
    private UserService userService;
    private List<Checker> checkers = new ArrayList<>();

    @Before
    public void setUp() {
        this.user = new User("jani1516", "asdasd123");

        this.userArray.add(new User("bozsineni42", "rozsaszinsundisznocska"));
        this.userArray.add(new User("bela2627", "dsafgh456"));
        this.userArray.add(new User("pisti5623", "password123"));

        this.passwordValidator = new PasswordValidator();
        this.usernameValidator = new UsernameValidator();
        this.userService = new UserServiceImpl();

        this.checkers.add(new UsernameValidator());
        this.checkers.add(new PasswordValidator());
    }

    @Test
    public void check_with_valid_user() {
        for (Checker checker : checkers) {
            Assert.assertTrue(checker.valid(this.user).isValid());
        }
    }

    @Test
    public void check_with_valid_user_list() {
        for (User user : this.userArray) {
            Assert.assertTrue(this.passwordValidator.valid(user).isValid());
        }
    }

    @Test
    public void save_empty_checker_array() {
        userController = new UserController(userService, null);
        Assert.assertTrue(userController.validUser(this.user));
    }

    @Test
    public void check_with_null_input() {
        ValidatorResponse validatorResponse = new ValidatorResponse(false, ErrorList.PASSWORD_IS_TOO_SHORT.toString());
        ValidatorResponse validatorResponse2 = new ValidatorResponse(false, ErrorList.USERNAME_IS_TOO_SHORT.toString());
        this.user.setPassword("");
        this.user.setUsername("");
        Assert.assertThat(this.passwordValidator.valid(this.user).getMessage(), is(validatorResponse.getMessage()));
        Assert.assertThat(this.usernameValidator.valid(this.user).getMessage(), is(validatorResponse2.getMessage()));
    }

    @Test
    public void check_with_too_short_password() {
        ValidatorResponse validatorResponse = new ValidatorResponse(false, ErrorList.PASSWORD_IS_TOO_SHORT.toString());
        this.user.setPassword("a");
        Assert.assertThat(this.passwordValidator.valid(this.user).getMessage(), is(validatorResponse.getMessage()));
    }

    @Test
    public void check_with_whitespace_in_password() {
        ValidatorResponse validatorResponse = new ValidatorResponse(false, ErrorList.PASSWORD_CONTAINS_WHITESPACE.toString());
        this.user.setPassword("white space");
        Assert.assertThat(this.passwordValidator.valid(this.user).getMessage(), is(validatorResponse.getMessage()));
    }

    @Test
    public void check_with_too_short_username() {
        ValidatorResponse validatorResponse = new ValidatorResponse(false, ErrorList.USERNAME_IS_TOO_SHORT.toString());
        this.user.setUsername("asd");
        Assert.assertThat(this.usernameValidator.valid(this.user).getMessage(), is(validatorResponse.getMessage()));
    }

    @Test
    public void check_with_whitespace_in_username() {
        ValidatorResponse validatorResponse = new ValidatorResponse(false, ErrorList.USERNAME_CONTAINS_WHITESPACE.toString());
        this.user.setUsername("feri keh");
        Assert.assertThat(this.usernameValidator.valid(this.user).getMessage(), is(validatorResponse.getMessage()));
    }

}
