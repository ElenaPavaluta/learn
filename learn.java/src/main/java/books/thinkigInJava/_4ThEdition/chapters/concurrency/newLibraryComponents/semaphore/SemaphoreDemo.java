package books.thinkigInJava._4ThEdition.chapters.concurrency.newLibraryComponents.semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

class SemaphoreDemo {
    final static int SIZE = 25;

    static void m() throws InterruptedException {
        final Pool<Fat> pool = new Pool<>(Fat.class, SIZE);
        ExecutorService exec = Executors.newCachedThreadPool();

        IntStream.range(0, SIZE).forEach(i -> exec.execute(new CheckoutTask<>(pool)));

        System.out.println("All checkedOut tasks created");

        List<Fat> list = new ArrayList<>();

        for(int i = 0; i < SIZE; i++) {
            Fat f = pool.checkOut();
            System.out.println(" | " + i + " : main() thread checked out");
            f.operation();
            list.add(f);
        }

        Future<?> blocked = exec.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    //Semaphore prevents additional checkout so call is blocked
                    pool.checkOut();
                } catch(InterruptedException e) {
                    System.out.println("checkdOut() interrupted");
                }
            }
        });

        TimeUnit.SECONDS.sleep(2);
        blocked.cancel(true);  //break out of blocked call
        System.out.println("Checking in objects in " + list);

        list.forEach(pool::checkIn);
        list.forEach(pool::checkIn);  //second check in ignored

        exec.shutdownNow();
    }

    public static void main(String[] args) throws InterruptedException {
        m();
    }
}
