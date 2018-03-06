package books.thinkigInJava4ThEdition.chapters.concurrency.coopertationBetweenTasks.producersAndConsumers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Restaurant {

    Meal meal;
    WaitPerson waitPerson = new WaitPerson(this);
    Chef chef = new Chef(this);
    ExecutorService exec = Executors.newCachedThreadPool();

    public Restaurant() {
        exec.execute(chef);
        exec.execute(waitPerson);
    }

    static void m() {
        new Restaurant();
    }

    public static void main(String[] args) {
        m();
    }
}
