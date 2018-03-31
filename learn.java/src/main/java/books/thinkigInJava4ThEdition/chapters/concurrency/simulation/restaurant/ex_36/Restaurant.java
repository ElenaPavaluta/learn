package books.thinkigInJava4ThEdition.chapters.concurrency.simulation.restaurant.ex_36;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.IntStream;

class Restaurant implements Runnable {
    static final int MAX_TABLE_SEATS = 12;
    static Random rand = new Random(47);
    BlockingQueue<OrderTicket> orderTickets = new LinkedBlockingQueue<>();
    private Tables tables;
    private Entrance entrance;
    private BlockingQueue<Waiter> waiters = new PriorityBlockingQueue<>();
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

    public BlockingQueue<Waiter> getWaiters() {
        return waiters;
    }

    public Entrance getEntrance() {
        return entrance;
    }

    public Tables getTables() {
        return tables;
    }

    public Optional<Table> tableFor(int size) {
        return tables.tableFor(size);
    }

    public List<Person> receiveCustomers() throws InterruptedException {
        return entrance.queue.take();
    }

    public void addToWaitingList(List<Person> group) throws InterruptedException {
        entrance.queue.put(group);
    }

    public Waiter availableWaiter() throws InterruptedException {
        return getWaiters().take();
    }

    public void placeOrder(SingleTableOrder tableOrder) {

    }

    public void cleanTable(Table table) {

    }

    public Table getDirtyTable() {
    }

    public void tableCleaned(Table table) {
        tables.
    }
}
