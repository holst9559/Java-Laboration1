package org.example;

import java.util.ArrayList;
import java.util.Collections;

import static org.example.Menu.staticMenu;

public class Prices {

    public static ArrayList<Integer> prices = new ArrayList<>();

    public static void minMaxAverage() {
        if (prices.size() < 24) {
            System.out.println("Det finns inte tillräckligt med information, mata in elpriser först.");
            staticMenu();
        }


        Integer min = Collections.min(prices);
        int indexMin = prices.indexOf(min);

        Integer max = Collections.max(prices);
        int indexMax = prices.indexOf(max);

        Integer average = averageSum();

        System.out.printf("Dygnets lägsta pris: %d öre/kWh kl: %d-%d", min, indexMin, indexMin + 1);
        System.out.printf('\n' + "Dygnets högsta pris: %d öre/kWh kl: %d-%d", max, indexMax, indexMax + 1);
        System.out.printf('\n' + "Dygnets medelpris: %d öre/kWh", average);
        System.out.println('\n');
        staticMenu();

    }


    private static int averageSum() {
        return prices.stream()
                .mapToInt(a -> a)
                .sum();

    }
}
