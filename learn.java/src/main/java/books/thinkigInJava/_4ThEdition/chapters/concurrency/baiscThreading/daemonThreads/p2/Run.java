package books.thinkigInJava._4ThEdition.chapters.concurrency.baiscThreading.daemonThreads.p2;

import java.util.concurrent.TimeUnit;

/**
 * If a thread is a daemon, then any threads it creates will automatically be daemons
 */
class Run {

    static void m(){
        Thread t = new Thread(new Daemon());
        t.setDaemon(true);
        t.start();
        System.out.println("t is daemon: " + t.isDaemon());
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        m();
    }
}
