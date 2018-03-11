package books.thinkigInJava4ThEdition.chapters.concurrency.coopertationBetweenTasks.producersAndConsumers;

import java.util.concurrent.TimeUnit;

class Chef implements Runnable {
    private Restaurant restaurant;
    private int count = 0;


    public Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                synchronized(this) {
                    while(restaurant.meal != null) {
                        wait();  //for the meal to be taken
                    }
                }
                if(++count == 5) {
                    System.out.println("out of food, closing");
                    restaurant.exec.shutdownNow();
                }
                System.out.println("Order up");
                synchronized(restaurant.waitPerson) {
                    restaurant.meal = new Meal(count);
                    restaurant.waitPerson.notifyAll();
                }
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch(InterruptedException e) {
            System.out.println("Chef interrupted");
        }
    }
}

