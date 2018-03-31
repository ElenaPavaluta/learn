package books.thinkigInJava4ThEdition.chapters.concurrency.simulation.restaurant.ex_36;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

import static java.util.stream.Collectors.toMap;

class SingleTableOrder {

    private Map<Customer, Food> map;
    private Waiter waiter;
    private Table table;
    private CountDownLatch countDownLatch;


    public SingleTableOrder(Table table, Waiter waiter, List<Customer> customers) {
        this.table = table;
        this.waiter = waiter;
        map = customers.stream()
                       .collect(toMap(c -> c,
                                      null,
                                      null,
                                      ConcurrentHashMap::new));
    }

    SingleTableOrder(SingleTableOrder order) {
        this.map = order.map;
        this.waiter = order.waiter;
        this.table = order.table;
    }

    public void addCustomerOrder(Customer customer, Food food) {
        map.put(customer, food);

    }

    boolean complete() {
        return !map.containsValue(null);
    }

    boolean readyToServe() {
        return map.values()
                  .stream()
                  .filter(Food::isCooked)
                  .count() == 0;
    }

    boolean emptyTable() {
        return map.isEmpty();
    }

    public void removeCustomer(Customer customer) {
        map.remove(customer);
    }

    public Table getTable() {
        return table;
    }
}
