package books.thinkigInJava4ThEdition.chapters.concurrency.simulation.restaurant.ex_36;

import java.util.Random;

public enum Menu {


    A_food, B_food, C_food, D_food, E_food, F_food, G_food, H_food;

    static Food randomSelect() {
        Random random = new Random(47);
        int pos = random.nextInt(Menu.values().length);
        return new Food(Menu.values()[pos].name());
    }
}
