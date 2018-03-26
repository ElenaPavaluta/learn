package books.thinkigInJava4ThEdition.chapters.concurrency.simulation.restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

class Restaurant implements Runnable {
    private static Random rand = new Random(47);
    BlockingQueue<Order> orders = new LinkedBlockingQueue<>();
    private List<Waiter> waiters = new ArrayList<>();
    private List<Chef> chefs = new ArrayList<>();
    private ExecutorService exec;

    Restaurant(ExecutorService exec, int nWaitPers, int nChefs) {
        this.exec = exec;
        IntStream.range(0, nWaitPers)
                 .forEach(i -> {
                     Waiter waiter = new Waiter(this);
                     waiters.add(waiter);
                     exec.execute(waiter);
                 });

        IntStream.range(0, nChefs)
                 .forEach(i -> {
                     Chef chef = new Chef(this);
                     chefs.add(chef);
                     exec.execute(chef);
                 });
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                //a new person arrives; assign a waiter
                Waiter waiter = waiters.get(rand.nextInt(waiters.size()));
                Customer customer = new Customer(waiter);
                exec.execute(customer);
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch(InterruptedException e) {
            System.out.println(this.getClass().getSimpleName() + " interrupted");
        }
        System.out.println(this.getClass().getSimpleName() + " closing");
    }
}
