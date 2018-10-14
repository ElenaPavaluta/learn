package oc.p.tests.chapters._14._10;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

class Market {

    static void checkPrices(List <Double> list, DoubleConsumer scanner) {
        list.forEach((Consumer <? super Double>) scanner);
    }

    public static void main(String[] args) {
        List <Double> prices = Arrays.asList(1.2, 6.5, 3.0);
        checkPrices(prices,
                p -> {
                    String res = p < 5 ? "Correct" : "Too high";
                    System.out.println(res);
                });
    }
}
