package books.thinkigInJava._4ThEdition.chapters.concurrency.baiscThreading.daemonThreads.p3;

import java.util.concurrent.TimeUnit;

/**
 *
 * Daemon threads will terminate their run() methods without executing finally clauses:
 *
 */
class Run {

    class Daemon implements Runnable{
        @Override
        public void run() {
            System.out.println("Starting daemon");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println("This is run in every circumstance, excepting for a daemon thread");
            }
        }
    }

    static void m(){
        Thread t = new Thread(new Run(). new Daemon());
        t.setDaemon(true);
        t.start();
    }

    public static void main(String[] args) {
        m();
    }
}
