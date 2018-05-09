package books.thinkigInJava._4ThEdition.chapters.concurrency.simulation.restaurant;

import java.util.Random;
import java.util.concurrent.TimeUnit;

class Chef implements Runnable {
    private static int counter = 0;
    private static Random rand = new Random(47);
    private final int id = counter++;
    private final Restaurant restaurant;

    public Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()){
                //blocks until an order appears
                Order order = restaurant.orders.take();
                Food requestedItem = order.getFood();
                //time to prepare food
                TimeUnit.MILLISECONDS.sleep(500);
                Plate plate = new Plate(order, requestedItem);
                order.getWaiter().filledOrders.put(plate);
            }
        } catch(InterruptedException e) {
            System.out.println(this + " interrupted");
        }
        System.out.println(this + " off duty");
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + id;
    }
}
