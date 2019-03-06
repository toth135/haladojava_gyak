package hu.me;

import com.fasterxml.jackson.databind.ObjectMapper;
import hu.me.logika.CalculatorImpl;

import java.io.IOException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) {

        ObjectMapper objectMapper = new ObjectMapper();
        CalculatorImpl calc = new CalculatorImpl();
        Scanner sc = new Scanner(System.in);
        KeresFeldolgozo keresFeldolgozo = new KeresFeldolgozo(calc);

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