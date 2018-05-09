package books.thinkigInJava._4ThEdition.chapters.concurrency.coopertationBetweenTasks.producersAndConsumers.ex.ex_26;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Restaurant {

    Meal meal;
    Table table;
    Waiter waiter = new Waiter(this);
    Chef chef = new Chef(this);
    BusBoy busBoy = new BusBoy(this);
    ExecutorService exec = Executors.newCachedThreadPool();

    public Restaurant() {
        exec.execute(chef);
        exec.execute(waiter);
        exec.execute(busBoy);
    }

    static void m() {
        new Restaurant();
    }

    public static void main(String[] args) {
        m();
    }
}
