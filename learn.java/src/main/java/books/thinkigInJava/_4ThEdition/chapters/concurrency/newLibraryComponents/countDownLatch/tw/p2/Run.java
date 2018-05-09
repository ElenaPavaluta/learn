package books.thinkigInJava._4ThEdition.chapters.concurrency.newLibraryComponents.countDownLatch.tw.p2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Run {
    Buff buff = new Buff();
    CountDownLatch countDownLatch = new CountDownLatch(1);
    CountDownLatch countDownLatch2 = new CountDownLatch(1);
    CountDownLatch countDownLatch3 = new CountDownLatch(1);

    Runnable ana = () -> {
        buff.add("ana");
        countDownLatch.countDown();
    };
    Runnable are = () -> {
        try {
            countDownLatch.await();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        buff.add("are");
        countDownLatch2.countDown();
    };
    Runnable mere = () -> {
        try {
            countDownLatch2.await();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        buff.add("mere");
        countDownLatch3.countDown();
    };

    Runnable print = () -> {
        try {
            countDownLatch3.await();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(buff.get());
    };

    public static void main(String[] args) throws InterruptedException {
        new Run().m();
    }

    void m() throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(print);
        TimeUnit.MILLISECONDS.sleep(250);
        exec.execute(mere);
        TimeUnit.MILLISECONDS.sleep(250);
        exec.execute(are);
        TimeUnit.MILLISECONDS.sleep(250);
        exec.execute(ana);

        exec.shutdown();
    }
}
