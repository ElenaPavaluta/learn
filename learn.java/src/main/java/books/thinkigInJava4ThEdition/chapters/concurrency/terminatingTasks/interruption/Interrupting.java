package books.thinkigInJava4ThEdition.chapters.concurrency.terminatingTasks.interruption;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class Interrupting {

    static ExecutorService exec = Executors.newCachedThreadPool();

    static void m(Runnable r) {
        Thread t = new Thread(r);
        t.start();
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
    }

    static void ms(){
//        m(new SleepBlocked());
//        m(new IOBlocked(System.in));
        m(new SynchronizedBlock());

    }

    public static void main(String[] args) throws InterruptedException {
        ms();
//        test(new SleepBlocked());
    }
}
