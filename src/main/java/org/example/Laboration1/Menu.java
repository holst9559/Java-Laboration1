package org.example.Laboration1;

import static org.example.Laboration1.PriceApp.scanner;
import static org.example.Laboration1.Prices.*;
import static org.example.Laboration1.UserInput.readInput;

public class Menu {
    public static void staticMenu() {
        System.out.println("Elpriser");
        System.out.println("-----------");
        System.out.println("1. Inmatning");
        System.out.println("2. Min, Max och Medel");
        System.out.println("3. Sortera");
        System.out.println("4. Bästa laddningstid (4h)");
        System.out.println("e. Avsluta");

        menuChoice();
    }

    public static void menuChoice() {
        System.out.println("Völj ett alternativ: ");
        var input = scanner.nextLine();
        switch (input.toLowerCase()) {
            case "1" -> {
                System.out.println("Du har valt 1: Imatning");
                readInput();
            }
            case "2" -> {
                System.out.println("Du har valt 2: Min, Max, och Medel");
                minMaxAverage();
            }
            case "3" -> {
                System.out.println("Du har valt 3: Sortera");
                sortPrices();
            }
            case "4" -> {
                System.out.println("Du har valt 4: Bästa laddningstid (4h)");
                optimalChargingTime();
            }
            case "e" -> {
                System.out.println("Du har valt att avsluta programmet");
                System.exit(0);

            }
            default -> {
                System.out.println("Ogiltigt menyval, försök igen med ett menyval från listan");
                staticMenu();
            }
        }
    }
}
