package books.thinkigInJava4ThEdition.chapters.concurrency.newLibraryComponents.semaphore.tw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Semaphore;

class Pool implements Runnable {
    private int n;
    private List<Integer> pool;
    private Semaphore semaphore;

    public Pool(int n) {
        this.n = n;
        pool = Collections.synchronizedList(new ArrayList<>());
        semaphore = new Semaphore(n);
    }

    synchronized void acquire(int id) {
        try {
            semaphore.acquire();
            pool.add(id);
            notifyAll();
        } catch(InterruptedException e) {
        }
    }

    synchronized void release(int id) {
        pool.remove(Integer.valueOf(id));
        semaphore.release();
    }


    @Override
    public synchronized void run() {
        try {
            while(!Thread.interrupted()) {
                wait();
                System.out.println(pool);
                System.out.println();
            }
        } catch(InterruptedException e) {
            System.out.println("Poool interrupted");
        }
    }

}
