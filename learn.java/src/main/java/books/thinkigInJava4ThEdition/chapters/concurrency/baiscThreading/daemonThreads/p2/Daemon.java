package books.thinkigInJava4ThEdition.chapters.concurrency.baiscThreading.daemonThreads.p2;

/**
 *
 * If a thread is a daemon, then any threads it creates will automatically be daemons
 *
 */
class Daemon implements Runnable {

    private Thread[] threads = new Thread[10];

    @Override
    public void run() {
        for(int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Daemon());
            threads[i].start();
            System.out.println("DaemonSpawn: " + i);
        }
        for(int i = 0; i < 10; i++) {
            System.out.println("threads[" + i + "].isDaemon(): " + threads[i].isDaemon());
        }
        while(true) {
            Thread.yield();
        }
    }
}
