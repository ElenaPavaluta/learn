package books.thinkigInJava4ThEdition.chapters.concurrency.newLibraryComponents.semaphore.tw;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

class Pool implements Runnable {
    private BlockingQueue<Integer> pool;
    private Semaphore semaphore;

    public Pool(int n) {
        semaphore = new Semaphore(n);
        pool = new ArrayBlockingQueue<Integer>(100);
    }

    synchronized void acquire(int id) {
        try {
            semaphore.acquire();
            pool.put(id);
            notifyAll();
        } catch(InterruptedException e) {
        }
    }

    void release() {
        try {
            pool.take();
            semaphore.release();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public synchronized void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(500);
            while(!Thread.interrupted()) {
                wait();
                System.out.println(pool);
                System.out.println();
            }
        } catch(InterruptedException e) {
            System.out.println("Pool interrupted");
        }
    }
}
