package books.thinkigInJava4ThEdition.chapters.concurrency.newLibraryComponents.semaphore.tw;

import java.util.Random;
import java.util.concurrent.TimeUnit;

class Task implements Runnable {
    int id;
    Pool pool;

    public Task(int id, Pool pool) {
        this.id = id;
        this.pool = pool;
    }

    @Override
    public void run() {
        try {
            pool.acquire(id);
            TimeUnit.MILLISECONDS.sleep(100);
            pool.release(id);
        } catch(InterruptedException e) {
            System.out.println(id + " interrupted");
        }

    }
}
