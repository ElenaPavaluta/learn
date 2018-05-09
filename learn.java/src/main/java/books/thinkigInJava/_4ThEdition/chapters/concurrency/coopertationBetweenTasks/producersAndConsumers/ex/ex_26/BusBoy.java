package books.thinkigInJava._4ThEdition.chapters.concurrency.coopertationBetweenTasks.producersAndConsumers.ex.ex_26;

class BusBoy implements Runnable {

    private Restaurant restaurant;

    public BusBoy(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        while(!Thread.interrupted()){
            try {
                synchronized(this){
                    while(restaurant.table == null){
                        wait();
                    }
                }
                synchronized(restaurant.waiter){
                    System.out.println("Table cleaned: " + restaurant.table);
                    restaurant.table = null;
                    restaurant.waiter.notify();
                }
            }catch(InterruptedException e){
                System.out.println("BusBoy interrupted");
            }
        }
    }
}
