package books.thinkigInJava._4ThEdition.chapters.concurrency.coopertationBetweenTasks.waitAndNotifyAll.ex.ex_21.ilegalMonitorStateException;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Throws java.lang.IllegalMonitorStateException due to the fact that the
 * wait() and notifyAll() methods
 * are not being called from synchronized method or code block
 */
class Run {

    static void m() throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Run().new R());
        exec.execute(new Run().new R2());
        TimeUnit.SECONDS.sleep(4);
        exec.shutdownNow();
    }

    public static void main(String[] args) throws InterruptedException {
        m();
    }

    class R implements Runnable {
        @Override
        public void run() {
            System.out.println("R run entered");
            try {
                wait();
                System.out.println("R before sleep()");
            } catch(InterruptedException e) {
                System.out.println("R interrupted : " + e.getMessage());
            }
            System.out.println("This is my message");
        }
    }

    class R2 implements Runnable {

        @Override
        public void run() {
            System.out.println("R2 entered");
            try {
                TimeUnit.SECONDS.sleep(2);
                notifyAll();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
