package books.thinkigInJava._4ThEdition.chapters.concurrency.coopertationBetweenTasks.usingExplicitLockAndConditionObjects.ex.ex_27;

import java.util.concurrent.TimeUnit;

class Waiter implements Runnable {
    private Restaurant restaurant;

    public Waiter(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                restaurant.waiToPrepareOrder();
                restaurant.deliverOrder();
                TimeUnit.MILLISECONDS.sleep(200);
            }
        } catch(InterruptedException e) {
            System.out.println("Waiter interrupted");
        }
    }
}
