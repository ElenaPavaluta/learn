package books.thinkigInJava._4ThEdition.chapters.concurrency.simulation.restaurant.ex_36;

class Chef implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private final Restaurant restaurant;

    public Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                SingleTableOrder tableOrder = restaurant.getTableOrder();
                Food f = tableOrder.customersOrders()
                          .stream()
                          .filter(food -> !food.isCooked())
                          .findFirst().get();
                f.cook();
                System.out.println(this + " cooked: " + f);
                if(tableOrder.isOrderReadyToBeServer()) {
                    restaurant.orderReady(tableOrder);
                } else {
                    restaurant.orderIncomplete(tableOrder);
                }
            }
        } catch(InterruptedException e) {
            System.out.println(this + " interrupted");
        }
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + id;
    }
}
