package books.thinkigInJava4ThEdition.chapters.concurrency.simulation.restaurant.tw;

import java.util.Random;

class Waiter implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private int ordersTaken = 0;
    private final Restaurant restaurant;
    private Random rand;

    public Waiter(Restaurant restaurant, Random rand) {
        this.rand = rand;
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {

            }
        } catch(InterruptedException e) {
            System.out.println(this + " interrupted");
        }
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + id;
    }

    void takeOrder(Dish dish) {
        restaurant.takeOrder(dish);
    }

    public Menu menu() {
        restaurant.menu();
    }
}
