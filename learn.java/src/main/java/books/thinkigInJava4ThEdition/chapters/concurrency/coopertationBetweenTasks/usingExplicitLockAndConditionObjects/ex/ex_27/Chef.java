package books.thinkigInJava4ThEdition.chapters.concurrency.coopertationBetweenTasks.usingExplicitLockAndConditionObjects.ex.ex_27;

import java.util.concurrent.TimeUnit;

class Chef implements Runnable {

    private Restaurant restaurant;
    private int count;

    public Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()){
                restaurant.prepareOrder();
                restaurant.waitToDeliverOrder();
                TimeUnit.MILLISECONDS.sleep(200);
            }
        }catch(InterruptedException e){
            System.out.println("Chef interrupted");
        }
    }
}
