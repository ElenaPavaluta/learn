package books.thinkigInJava4ThEdition.chapters.concurrency.simulation.restaurant.tw;

import java.util.Random;
import java.util.concurrent.TimeUnit;

class CustomerGenerator implements Runnable {

    final char lastChar;
    private final Restaurant restaurant;
    private final Random random;

    public CustomerGenerator(char lastChar, Restaurant restaurant, Random random) {
        this.lastChar = lastChar;
        this.restaurant = restaurant;
        this.random = random;
    }

    @Override
    public void run() {
        try {
            for(char c = 'a'; c < lastChar; c++) {
                TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));
                Customer customer = new Customer(c, restaurant);
                restaurant.receive(customer);
            }
        } catch(InterruptedException e) {
            System.out.println(this + " interrupted");
        }
        System.out.println("No more clients accepted");
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
