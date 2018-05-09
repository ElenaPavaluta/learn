package books.thinkigInJava._4ThEdition.chapters.concurrency.simulation.restaurant;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class Waiter implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private final Restaurant restaurant;

    BlockingQueue<Plate> filledOrders = new LinkedBlockingQueue<>();

    public Waiter(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                //block until a course is ready
                Plate plate = filledOrders.take();
                System.out.println(this + " received: " + plate + " | delivering to : " + plate.getOrder().getCustomer());
                plate.getOrder().getCustomer().deliver(plate);
            }
        } catch(InterruptedException e) {
            System.out.println(this + " interrupted");
        }
        System.out.println("this " + " off duty");
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + id;
    }

    public void placeOrder(Customer customer, Food food) {
        try {
            //shouldn't actually block because this is a LinkedBlockingQueue with no size limit
            restaurant.orders.put(new Order(customer, this, food));
        } catch(InterruptedException e) {
            System.out.println(this + " place order interrupted");
        }
    }
}
