package books.thinkigInJava._4ThEdition.chapters.concurrency.coopertationBetweenTasks.usingExplicitLockAndConditionObjects;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class WaxOnMaric {

    static void m() throws InterruptedException {
        System.out.println();
        Car c = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOff(c));
        exec.execute(new WaxOn(c));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }

    public static void main(String[] args) throws InterruptedException {
        m();
    }
}
