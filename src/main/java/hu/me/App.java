package hu.me;

import com.fasterxml.jackson.databind.ObjectMapper;
import hu.me.logika.CalculatorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */

@SpringBootApplication
public class App implements CommandLineRunner {

    private KeresFeldolgozo keresFeldolgozo;

    @Autowired
    public void setKeresFeldolgozo(KeresFeldolgozo keresFeldolgozo) {
        this.keresFeldolgozo = keresFeldolgozo;
    }

    public static void main(String[] args ) {

        SpringApplication.run(App.class, args);

    }

    @Override
    public void run(String... args) throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        Scanner sc = new Scanner(System.in);

        String calcJson =
                "{ \"muvelet\" : \"+\",  " +
                        "\"operandus1\" : 3," +
                        " \"operandus2\" : 6}";

        try {
            InputValues input = objectMapper.readValue(calcJson, InputValues.class);

            System.out.println("Adjon meg egy operátort: ");
            input.setMuvelet(sc.next());
            System.out.println("Adja meg az első számot: ");
            input.setOperandus1(sc.nextInt());
            System.out.println("Adja meg a második számot: ");
            input.setOperandus2(sc.nextInt());


            String json = objectMapper.writeValueAsString(keresFeldolgozo.feldolgoz(input));
            System.out.println(json);

        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }
}