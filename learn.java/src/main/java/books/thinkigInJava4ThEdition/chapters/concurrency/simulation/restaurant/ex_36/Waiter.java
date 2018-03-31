package books.thinkigInJava4ThEdition.chapters.concurrency.simulation.restaurant.ex_36;

import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

class Waiter implements Runnable, Comparable<Waiter> {
    private static int counter = 0;
    private final int id = counter++;

    private final Restaurant restaurant;
    BlockingQueue<Plate> filledOrders = new LinkedBlockingQueue<>();
    private ToIntFunction<List<Table>> totalCustomers = l -> l.stream()
                                                              .mapToInt(Table::capacity)
                                                              .reduce(Integer::sum)
                                                              .getAsInt();
    private Map<Table, SingleTableOrder> tableOrders = new ConcurrentHashMap<>();


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

        return Integer.compare(totalCustomers.applyAsInt(tables()),
                               o.totalCustomers.applyAsInt(o.tables()));
    }

    private List<Table> tables() {
        return tableOrders.keySet().stream().collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + id;
    }

    public void placeOrder(Customer customer, Food food) {
        SingleTableOrder tableOrder = tableOrders.get(customer.getTable());
        tableOrder.addCustomerOrder(customer, food);
        if(tableOrder.complete()) {
            restaurant.placeOrder(tableOrder);
        }
    }

    public void seatCustomer(Table table, List<Person> group) {
        tableOrders.put(table, new SingleTableOrder(table, this, customers(group, table)));
    }

    private List<Customer> customers(List<Person> group, Table table) {
        return group.stream()
                    .map(p -> new Customer(p, this, table))
                    .collect(Collectors.toList());
    }

    public void leaving(Customer customer) {
        SingleTableOrder tableOrder = tableOrders.get(customer.getTable());
        tableOrder.removeCustomer(customer);
        if(tableOrder.emptyTable()){
            tableOrders.remove(tableOrder.getTable());
            restaurant.cleanTable(tableOrder.getTable());
        }
    }
}
