package books.thinkigInJava4ThEdition.chapters.concurrency.newLibraryComponents.countDownLatch.ex_32;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Run {

    static int n = 5;

    static CountDownLatch countDownLatch = new CountDownLatch(n);
    static {
        Entrance.countDownLatch = countDownLatch;
    }
    static CountDownLatch countDwonLatch2 = new CountDownLatch(1);


    static Runnable totalCount = () -> {
        try {
            countDwonLatch2.await();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Total: " + Entrance.getTotalCount());
    };

    static Runnable sumTask = () -> {
        System.out.println("Sum of Entrances: " + Entrance.sumEntrances());
        countDwonLatch2.countDown();
    };


    static void m() throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(totalCount);
        exec.execute(sumTask);
        for(int i = 0; i < n; i++) {
            exec.execute(new Entrance(i));
        }

        TimeUnit.SECONDS.sleep(3);
        Entrance.cancel();
        exec.shutdown();
    }

    public static void main(String[] args) throws InterruptedException {
        m();
    }
}
