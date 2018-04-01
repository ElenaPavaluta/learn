package books.thinkigInJava4ThEdition.chapters.concurrency.simulation.restaurant.ex_36;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.ToIntFunction;

class SingleTableOrder implements Comparable<SingleTableOrder> {

    private Map<Customer, Food> map;
    private Waiter waiter;
    private Table table;
    private ToIntFunction<Map<Customer, Food>> function = m -> (int) m.values()
                                                                      .stream()
                                                                      .filter(v -> v != Menu.NOTHING)
                                                                      .count();


    public SingleTableOrder(Table table, Waiter waiter, List<Customer> customers) {
        this.table = table;
        this.waiter = waiter;
        map = new ConcurrentHashMap<>();
        customers.forEach(c -> map.put(c, Food.NOTHING));
    }

    Set<Customer> customers() {
        return map.keySet();
    }

    public void addCustomerOrder(Customer customer, Food food) {
        map.put(customer, food);
    }

    boolean allTableCustomersOrdered() {
        return !map.values().contains(Menu.NOTHING);
    }

    boolean isOrderReadyToBeServer(){
       return  map.values().stream().filter(f->!f.isCooked()).count() ==0;
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

    public Food getFoodForCustomer(Customer customer) {
        return map.get(customer);
    }

    @Override
    public int compareTo(SingleTableOrder o) {
        return Integer.compare(function.applyAsInt(map), function.applyAsInt(o.map));
    }

    public Waiter waiter() {
        return waiter;
    }

    public Collection<Food> customersOrders() {
        return map.values();
    }
}
