package hu.me;

import hu.me.UserValidator.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static UserService userService = new UserServiceImpl();
    private static PasswordValidator passwordValidator = new PasswordValidator();
    private static UsernameValidator usernameValidator = new UsernameValidator();

    private static Scanner sc = new Scanner(System.in);
    private static List<Checker> checkers = new ArrayList<>(2);
    private static UserController userController = new UserController(userService, checkers);

    public static void main(String[] args) {

        checkers.add(passwordValidator);
        checkers.add(usernameValidator);

        do{
            System.out.print("Adjon meg egy felhasználónevet: ");
            String username = sc.nextLine();
            System.out.print("Adjon meg egy jelszót: ");
            String password = sc.nextLine();
            try {
                userController.createUser(username, password);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Próbálkozik még? ( i / n )");
            String again = sc.nextLine();
            if (again.equals("i")) {
                continue;
            }
            else if (again.equals("n")){
                break;
            }
            else {
                System.out.println("Rossz billentyűt ütött le! ('i' = igen, 'n' = nem)");
                sc.nextLine();
            }
        }while(true);

    }

}

