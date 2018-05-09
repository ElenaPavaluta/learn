package books.thinkigInJava._4ThEdition.chapters.concurrency.newLibraryComponents.countDownLatch.ex_32;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

class Entrance implements Runnable {

    private static Count count = new Count();
    private static List<Entrance> entrances = new ArrayList<>();
    private static volatile boolean canceled = false;
    //doesn't need synchronization to read
    private final int id;
    static CountDownLatch countDownLatch;
    private int number = 0;

    Entrance(int id) {
        //Keep this task in a list. Also prevents gc of dead tasks
        this.id = id;
        //Keep this task in a list. Also prevents gc collection of dead tasks
        entrances.add(this);
    }

    //atomic operation on a volatile field-> doesn't need synchronisation
    static void cancel() {
        canceled = true;
    }

    static int getTotalCount() {
        return count.value();
    }

    @Override
    public void run() {
        while(!canceled) {
            synchronized(this) {
                number++;
            }
        }
        System.out.println(this + " Total: " + count.increment());
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch(InterruptedException e) {
            System.out.println("sleep() interrupted");
        }
        System.out.println("Stopping: " + this);
        countDownLatch.countDown();
    }

    synchronized int getValue() {
        return number;
    }

    @Override
    public String toString() {
        return "Entrance: " + id + ": " + getValue();
    }

    static int sumEntrances() {
        try {
            countDownLatch.await();
            int sum = 0;
            for(Entrance entrance : entrances) {
                sum += entrance.getValue();
            }
            return sum;
        } catch(InterruptedException e) {
            System.out.println("sumEntrances interrupted");
        }return  -1;
    }
}
