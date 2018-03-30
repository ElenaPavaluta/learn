package books.thinkigInJava4ThEdition.chapters.concurrency.simulation.restaurant.ex_36;

import java.util.List;
import java.util.function.Predicate;

class Table {

    private static int counter = 0;
    private final int tableNb = counter++;
    private final int capacity;

    public Table(int capacity) {
        this.capacity = capacity;
    }

    private Predicate<List<Customer>> emptyList = List::isEmpty;
    private Predicate<Waiter> existsWaiter = waiter1 -> waiter1 != null;

    private List<Customer> customerList;
    private Waiter waiter;

    void occupyTable(List<Customer> customers) {
        this.customerList = customers;
    }

    void releaseTable() {
        this.customerList = null;
        this.waiter = null;
    }

    void assignWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

    boolean isEmpty() {
        return emptyList.test(customerList) && !existsWaiter.test(waiter);
    }

    int size(){
        return customerList.size();
    }

}
