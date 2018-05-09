package books.thinkigInJava._4ThEdition.chapters.concurrency.simulation.restaurant.ex_36;

import java.util.List;
import java.util.Optional;

class TableManager implements Runnable {
    private Restaurant restaurant;

    public TableManager(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                List<Person> group = restaurant.receiveCustomers();
                Optional<Table> optTable = restaurant.tableFor(group.size());
                if(optTable.isPresent()) {
                    handleCustomers(group, optTable);
                } else {
                    if(customerWillingToWait()) {
                        restaurant.addToWaitingList(group);
                    }
                }

            }
        } catch(InterruptedException e) {
            System.out.println(this + " interrupted");
        }
    }

    private boolean customerWillingToWait() {
        return Restaurant.rand.nextBoolean();
    }

    private void handleCustomers(List<Person> group, Optional<Table> optTable) throws InterruptedException {
        Table table = optTable.get();
        Waiter waiter = restaurant.availableWaiter();
        waiter.seatCustomer(table, group);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
