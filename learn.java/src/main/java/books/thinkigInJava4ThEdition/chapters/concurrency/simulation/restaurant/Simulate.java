package books.thinkigInJava4ThEdition.chapters.concurrency.simulation.restaurant;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Simulate {

    static void m() throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        Restaurant restaurant = new Restaurant(exec, 5, 2);
        exec.execute(restaurant);

        TimeUnit.SECONDS.sleep(10);
        exec.shutdownNow();
    }

    public static void main(String[] args) throws InterruptedException {
        m();
    }
}
