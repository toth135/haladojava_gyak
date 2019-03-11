package hu.me;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class Main
{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CheckerImpl checker = new CheckerImpl();
        User user = new User();

        System.out.println("Kérem adjon meg egy felhasználónevet: ");
        user.setUsername(sc.next());

        System.out.println("Kérem adjon meg egy jelszót: ");
        user.setPassword(sc.next());

        checker.save(user.getUsername(), user.getPassword());

    }

}
