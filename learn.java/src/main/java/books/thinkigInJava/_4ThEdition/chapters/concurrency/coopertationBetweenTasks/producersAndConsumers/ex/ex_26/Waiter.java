package books.thinkigInJava._4ThEdition.chapters.concurrency.coopertationBetweenTasks.producersAndConsumers.ex.ex_26;

class Waiter implements Runnable {
    private Restaurant restaurant;
    private int count;

    public Waiter(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                synchronized(this) {
                    while(restaurant.meal == null) {
                        wait();  //for the chief to produce a meal
                    }
                    while(restaurant.table !=null){
                        wait();
                    }
                }
                System.out.println("WaitPerson got " + restaurant.meal);
                synchronized(restaurant.chef) {
                    restaurant.meal = null;
                    restaurant.chef.notify();  //ready for another
                }
                synchronized(restaurant.busBoy){
                    restaurant.table = new Table(++count);
                    restaurant.busBoy.notify();
                }
            }
        } catch(InterruptedException e) {
            System.out.println("WaitPerson interrupted()");
        }
    }
}
