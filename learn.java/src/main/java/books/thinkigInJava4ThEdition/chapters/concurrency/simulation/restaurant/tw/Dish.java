package books.thinkigInJava4ThEdition.chapters.concurrency.simulation.restaurant.tw;

class Dish {
    private final Customer customer;
    private final Waiter waiter;
    private final Plate plate;
    private Status status = Status.NEW;

    public Dish(Customer customer, Waiter waiter, Plate plate) {
        this.customer = customer;
        this.waiter = waiter;
        this.plate = plate;

    }

    public Customer getCustomer() {
        return customer;
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public Plate getPlate() {
        return plate;
    }

    @Override
    public String toString() {
        return "name: " + plate + " status : "+ status + "\n taken by: " + waiter;
    }

    public void consume() {
        status = Status.CONSUMED;
    }

    enum Status{
        NEW,
        COOKED,
        DELIVERED,
        CONSUMED,
        CLEARED;
    }
}
