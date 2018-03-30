package books.thinkigInJava4ThEdition.chapters.concurrency.simulation.restaurant.ex_36;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Restaurant implements Runnable {
    static final int MAX_TABLE_SEATS = 12;
    static Random rand = new Random(47);
    private BlockingQueue<PersonGroup>
    private List<Table> tables = Stream
            .<Table>generate(() -> new Table(rand.nextInt(MAX_TABLE_SEATS)))
            .collect(Collectors.toList());



    BlockingQueue<OrderTicket> orderTickets = new LinkedBlockingQueue<>();
    private List<Waiter> waiters = new ArrayList<>();
    private List<Chef> chefs = new ArrayList<>();
    private ExecutorService exec;

    Restaurant(ExecutorService exec, int nWaiters, int nChefs) {
        this.exec = exec;
        IntStream.range(0, nWaiters)
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
