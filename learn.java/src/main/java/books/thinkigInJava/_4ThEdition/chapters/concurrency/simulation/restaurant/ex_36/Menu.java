package books.thinkigInJava._4ThEdition.chapters.concurrency.simulation.restaurant.ex_36;

import java.util.Random;

enum Menu {


    A_food, B_food, C_food, D_food, E_food, F_food, G_food, H_food;

    public static final Food NOTHING = new Food("");

    static Food randomSelect() {
        Random random = new Random(47);
        int pos = random.nextInt(Menu.values().length);
        return new Food(Menu.values()[pos].name());
    }
}
