package books.thinkigInJava4ThEdition.chapters.concurrency.simulation.restaurant.ex_36;

import java.util.concurrent.TimeUnit;

class BusBoy implements Runnable {

    private Restaurant restaurant;

    public BusBoy(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()){
                Table table = restaurant.getDirtyTable();
                TimeUnit.MILLISECONDS.sleep(Restaurant.rand.nextInt(250));
                restaurant.tableCleaned(table);
            }
        }catch(InterruptedException e){
            System.out.println(this + " interrupted");
        }
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
