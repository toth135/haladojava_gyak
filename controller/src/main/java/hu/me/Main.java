package hu.me;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();
        EmptyValidator emptyValidator = new EmptyValidator();
        NoSpaceValidator noSpaceValidator = new NoSpaceValidator();
        PasswordLengthValidator passwordLengthValidator = new PasswordLengthValidator();
        UsernameLengthValidator usernameLengthValidator = new UsernameLengthValidator();
        List<Checker> checkers = new ArrayList<>(4);
        checkers.add(emptyValidator);
        checkers.add(noSpaceValidator);
        checkers.add(passwordLengthValidator);
        checkers.add(usernameLengthValidator);
        UserController userController = new UserController(userService, checkers);
        Scanner sc = new Scanner(System.in);
        ValidatorResponse validatorResponse = new ValidatorResponse();

        System.out.print("Adjon meg egy felhasználónevet: ");
        String username = sc.next();
        System.out.print("Adjon meg egy jelszót: ");
        String password = sc.next();
        userController.createUser(username, password);

    }

}
