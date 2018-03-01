package books.thinkigInJava4ThEdition.chapters.concurrency.terminatingTasks.interruption;

import java.util.concurrent.TimeUnit;

class SleepBlocked implements Runnable {

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }
    }
}
