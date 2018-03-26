package books.thinkigInJava4ThEdition.chapters.concurrency.simulation.restaurant;

//DTO
class Order {

    private static int counter = 0;
    private final int id = counter++;
    private final Customer customer;
    private final Waiter waiter;
    private final Food food;

    public Order(Customer customer, Waiter waiter, Food food) {
        this.customer = customer;
        this.waiter = waiter;
        this.food = food;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public Food getFood() {
        return food;
    }

    @Override
    public String toString() {
        return "Order: " + id + " item: " + food + " for " + customer + ", served by: " + waiter;
    }
}
