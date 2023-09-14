package org.example.Laboration1;

import static org.example.Laboration1.Menu.staticMenu;
import static org.example.Laboration1.PriceApp.scanner;
import static org.example.Laboration1.Prices.prices;

public class UserInput {

    public static void readInput() {

        for (int i = 0; i < 24; i++) {
            System.out.printf("Mata in pris för följande klockslag: %02d-%02d", i, i + 1);
            System.out.println('\n');

            var input = scanner.nextLine();

            //Metod här för att kontrollera input, hela ören.
            int price = checkInput(input);

            //Metod för att kontrollera att input är större än 0
            //Metod för att lägga till input i prices.
            if (price > 0) {
                prices.add(price);
            } else i--;

        }

        System.out.println("Värdena har sparats");
        staticMenu();
    }


    private static int checkInput(String input) {
        if (input == null) {
            return 0;
        }
        try {
            int i = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Ej tillåtet värde");
            return 0;
        }
        return Integer.parseInt(input);
    }
}
