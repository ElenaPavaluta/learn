package books.thinkigInJava4ThEdition.chapters.concurrency.simulation.restaurant.ex_36;

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
                OrderTicket orderTicket = restaurant.orderTickets.take();
                Food requestedItem = orderTicket.getFood();
                //time to prepare food
                TimeUnit.MILLISECONDS.sleep(500);
                Plate plate = new Plate(orderTicket, requestedItem);
                orderTicket.getWaiter().filledOrders.put(plate);
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
