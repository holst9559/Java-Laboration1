package org.example.Laboration1;

import java.util.ArrayList;
import java.util.Collections;

import static org.example.Laboration1.Menu.staticMenu;

public class Prices {

    public static ArrayList<Integer> prices = new ArrayList<>();

    public static void minMaxAverage() {
        checkList();


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

    public static void sortPrices() {
        checkList();

        ArrayList<PriceObj> sortedList = new ArrayList<>();

        for (var i = 0; i < prices.size(); i++) {
            sortedList.add(new PriceObj(prices.get(i), i));
        }

        Collections.sort(sortedList);

        System.out.println("Priser i fallande ordning");
        System.out.println('\n');

        for (PriceObj priceObj : sortedList) {
            System.out.printf("Kl: %02d-%02d %d öre", priceObj.timeIndex, priceObj.timeIndex + 1, priceObj.price);
            System.out.println('\n');
        }

        staticMenu();
    }

    public static void optimalChargingTime() {
        checkList();

        int sum = Integer.MAX_VALUE;
        int index = 0;

        for (int i = 0; i < 21; i++) {
            int tempPrice = prices.get(i) + prices.get(i + 1) + prices.get(i + 2) + prices.get(i + 3);
            if (tempPrice < sum) {
                sum = tempPrice;
                index = i;
            }
        }

        System.out.printf("Börja ladda mellan %02d-%02d för att få billigast pris, priset är då: %d öre/kWh", index, index + 1, sum);
        System.out.println('\n');
        staticMenu();
    }


    private static int averageSum() {
        return prices.stream()
                .mapToInt(a -> a)
                .sum();

    }

    private static void checkList() {
        if (prices.size() < 24) {
            System.out.println("Det finns inte tillräckligt med information, mata in elpriser först.");
            staticMenu();
        }
    }

    private static class PriceObj implements Comparable<PriceObj> {
        private Integer price;
        private Integer timeIndex;

        private PriceObj() {
            price = 0;
            timeIndex = 0;
        }

        private PriceObj(Integer price, Integer timeIndex) {
            this.price = price;
            this.timeIndex = timeIndex;
        }

        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }

        public Integer getTimeIndex() {
            return timeIndex;
        }

        public void setTime(Integer timeIndex) {
            this.timeIndex = timeIndex;
        }

        @Override
        public int compareTo(PriceObj e) {
            return this.getPrice().compareTo(e.getPrice());
        }
    }

}
