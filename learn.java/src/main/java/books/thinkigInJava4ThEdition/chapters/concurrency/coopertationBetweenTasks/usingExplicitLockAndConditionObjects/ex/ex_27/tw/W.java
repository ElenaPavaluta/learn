package books.thinkigInJava4ThEdition.chapters.concurrency.coopertationBetweenTasks.usingExplicitLockAndConditionObjects.ex.ex_27.tw;

import java.util.concurrent.TimeUnit;

class W implements Runnable {
    private R restaurant;

    public W(R restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                synchronized(this) {
                    while(restaurant.meal == null) {
                        wait();
                    }
                }
                synchronized(restaurant.chef) {
                    System.out.println("Meal delivered: " + restaurant.meal);
                    restaurant.meal = null;
                    restaurant.chef.notify();
                }
                TimeUnit.MILLISECONDS.sleep(200);
            }
        } catch(InterruptedException e) {
            System.out.println("Waiter interrupted");
        }
    }
}
