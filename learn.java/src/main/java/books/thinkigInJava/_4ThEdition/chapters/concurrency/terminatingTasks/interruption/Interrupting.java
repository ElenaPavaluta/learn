package books.thinkigInJava._4ThEdition.chapters.concurrency.terminatingTasks.interruption;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * I/O AND WAITING ON A SYNCHRONIZED LOCK ARE NOT INTERRUPTIBLE
 *
 * One cannot interrupt a task that is trying to acquire a synchronized
 * lock or one that is trying to perform I/O.
 */
class Interrupting {

    static ExecutorService exec = Executors.newCachedThreadPool();

    static void m(Runnable r) throws InterruptedException {
        Thread t = new Thread(r);
        t.start();
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("Interrupting: " + r.getClass().getSimpleName());
        t.interrupt();
        System.out.println("Interrupt sent to " + r.getClass().getSimpleName());
    }

    static void test(Runnable r) throws InterruptedException {
        Future<?> f = exec.submit(r);
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("Interrupting " + r.getClass().getSimpleName());
        f.cancel(true);
        System.out.println("Interrupt sent to " + r.getClass().getSimpleName());
        exec.shutdown();
    }

    static void ms() throws InterruptedException {
//        createAndPopulate(new SleepBlocked());
//        createAndPopulate(new IOBlocked(System.in));
//        createAndPopulate(new SynchronizedBlock());
    }

    static void mTest() throws InterruptedException {
//        test(new SleepBlocked());
//        test(new IOBlocked(System.in));
        test(new SynchronizedBlock());
    }

    public static void main(String[] args) throws InterruptedException {
//        ms();
        mTest();
    }
}
