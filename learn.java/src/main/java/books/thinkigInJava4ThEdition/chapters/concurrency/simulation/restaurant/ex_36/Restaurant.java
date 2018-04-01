package books.thinkigInJava4ThEdition.chapters.concurrency.simulation.restaurant.ex_36;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.stream.IntStream;

class Restaurant implements Runnable {
    static final int MAX_TABLE_SEATS = 12;
    static Random rand = new Random(47);
    private Tables tables = new Tables();
    private BlockingQueue<Table> tablesForCleaning = new LinkedBlockingQueue<>();
    private PriorityBlockingQueue<SingleTableOrder> ordersToBePrepared = new PriorityBlockingQueue<>();
    private BlockingQueue<Waiter> waiters = new PriorityBlockingQueue<>();
    private List<Chef> chefs = new ArrayList<>();
    private ExecutorService exec;
    private Entrance entrance;

    Restaurant(ExecutorService exec, int nWaiters, int nChefs) {
        this.exec = exec;
        IntStream.range(0, nWaiters)
                 .forEach(i -> {
                     Waiter waiter = new Waiter(this);
                     try {
                         waiters.put(waiter);
                     } catch(InterruptedException e) {
                         System.out.println(this + " constructor interrupted");
                     }
                 });

        IntStream.range(0, nChefs)
                 .forEach(i -> {
                     Chef chef = new Chef(this);
                     chefs.add(chef);
                 });
        System.out.println();
    }

    @Override
    public void run() {
        entrance = new Entrance(exec);
        exec.execute(entrance);
        exec.execute(new TableManager(this));
        exec.execute(new BusBoy(this));
        waiters.forEach(exec::execute);
        chefs.forEach(exec::execute);
    }

    public BlockingQueue<Waiter> getWaiters() {
        return waiters;
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
        ordersToBePrepared.put(tableOrder);
    }

    public void cleanTable(Table table) {
        try {
            tablesForCleaning.put(table);
        } catch(InterruptedException e) {
            System.out.println(this + " tableCleaned " + table + " interrupted");
        }
    }

    public Table getDirtyTable() throws InterruptedException {
        return tablesForCleaning.take();
    }

    public void tableCleaned(Table table) {
        tables.add(table);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    public SingleTableOrder getTableOrder() throws InterruptedException {
        return ordersToBePrepared.take();
    }

    public void orderReady(SingleTableOrder tableOrder) {
        tableOrder.waiter().addCompleteOrder(tableOrder);
    }

    public void orderIncomplete(SingleTableOrder tableOrder) {
        ordersToBePrepared.put(tableOrder);
    }

    public ExecutorService getExec() {
        return exec;
    }
}
