package books.thinkigInJava._4ThEdition.chapters.concurrency.newLibraryComponents.semaphore;

import java.util.concurrent.TimeUnit;

class CheckoutTask<T> implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private Pool<T> pool;

    public CheckoutTask(Pool<T> pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        try {
            T item = pool.checkOut();
            System.out.println(this + " checked out " + item);
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println(this + " checked in " + item);
            pool.checkIn(item);
        }catch(InterruptedException e){

        }
    }

    @Override
    public String toString() {
        return "CheckoutTask " + id + " ";
    }
}
