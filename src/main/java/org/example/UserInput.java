package org.example;
import java.util.Scanner;

import static org.example.Menu.staticMenu;
import static org.example.PriceApp.scanner;
import static org.example.Prices.prices;

public class UserInput {

    public static void readInput() {

        for (int i = 0; i < 24; i++) {
            System.out.println("Mata in pris för följande klockslag: ");
            if (i < 9) {
                System.out.println("0" + i + "-0" + (i+1));
            }else if (i == 9){
                System.out.println("09-10");

            }else {
                System.out.println(i + "-" + (i+1));

            }

            var input = scanner.nextLine();

            // Funktion här för att kontrollera input, hela ören.

            // Funktion för att kontrollera att input är större än 0

            // Funktion för att lägga till input i prices.




        }

        System.out.println("Värdena har sparats");
        staticMenu();
    }
}
