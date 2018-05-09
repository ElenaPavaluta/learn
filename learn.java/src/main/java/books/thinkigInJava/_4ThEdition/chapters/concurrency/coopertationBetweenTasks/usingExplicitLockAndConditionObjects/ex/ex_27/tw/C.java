package books.thinkigInJava._4ThEdition.chapters.concurrency.coopertationBetweenTasks.usingExplicitLockAndConditionObjects.ex.ex_27.tw;

import java.util.concurrent.TimeUnit;

class C implements Runnable {
    private R restaurant;
    private int count;

    public C(R restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                synchronized(this) {
                    while(restaurant.meal != null) {
                        wait();
                    }
                }
                synchronized(restaurant.waiter) {
                    restaurant.meal = new M(++count);
                    System.out.println("Prepared meal: " + restaurant.meal);
                    restaurant.waiter.notify();
                }
                TimeUnit.MILLISECONDS.sleep(200);
            }
        } catch(InterruptedException e) {
            System.out.println("C interrupted");
        }
    }

}
