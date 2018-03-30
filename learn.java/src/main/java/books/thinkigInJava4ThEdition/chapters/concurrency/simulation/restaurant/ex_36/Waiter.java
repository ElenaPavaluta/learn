package books.thinkigInJava4ThEdition.chapters.concurrency.simulation.restaurant.ex_36;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.ToIntFunction;

class Waiter implements Runnable, Comparable<Waiter> {
    private static int counter = 0;
    private final int id = counter++;
    private final Restaurant restaurant;
    BlockingQueue<Plate> filledOrders = new LinkedBlockingQueue<>();
    private List<Table> servedTables;
    private ToIntFunction<List<Table>> totalCustomers = l -> l.stream()
                                                              .mapToInt(Table::size)
                                                              .reduce(Integer::sum)
                                                              .getAsInt();

    public Waiter(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                //block until a course is ready
                Plate plate = filledOrders.take();
                System.out.println(this + " received: " + plate + " | delivering to : " + plate.getOrderTicket().getCustomer());
                plate.getOrderTicket().getCustomer().deliver(plate);
            }
        } catch(InterruptedException e) {
            System.out.println(this + " interrupted");
        }
        System.out.println("this " + " off duty");
    }

    @Override
    public int compareTo(Waiter o) {

        return Integer.compare(totalCustomers.applyAsInt(servedTables),
                               o.totalCustomers.applyAsInt(o.servedTables));
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + id;
    }

    public void placeOrder(Customer customer, Food food) {
        try {
            //shouldn't actually block because this is a LinkedBlockingQueue with no size limit
            restaurant.orderTickets.put(new OrderTicket(customer, this, food));
        } catch(InterruptedException e) {
            System.out.println(this + " place order interrupted");
        }
    }
}
