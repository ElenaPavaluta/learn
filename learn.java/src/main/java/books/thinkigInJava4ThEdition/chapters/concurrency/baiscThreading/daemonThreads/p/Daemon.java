package books.thinkigInJava4ThEdition.chapters.concurrency.baiscThreading.daemonThreads.p;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * A "daemon" thread is intended to provide a general service
 * in the background as long as the program is running,
 * but is not part of the essence of the program.
 * Thus, when all of the non-daemon threads complete,
 * the program is terminated, killing all daemon threads in the process.
 */
class Daemon implements Runnable {

    static void m() {
        for(int i = 0; i < 10; i++) {
            Thread daemon = new Thread(new Daemon());
            daemon.setDaemon(true); //Must call before start
            daemon.start();
        }

        System.out.println("All daemons started");

        try {
            TimeUnit.MILLISECONDS.sleep(175);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void m2() {
        for(int i = 0; i < 10; i++) {
            Thread daemon = new Thread(new Daemon());
            daemon.start();
            daemon.setDaemon(true);  //RE: throws IllegalStateException
        }

        System.out.println("All (non) daemons thread started.");
        try {
            TimeUnit.MILLISECONDS.sleep(175);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void m3() {
        ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory());
        for(int i= 0; i<10; i++){
            exec.execute(new Daemon());
        }

        System.out.println("All daemons started");
        try {
            TimeUnit.MILLISECONDS.sleep(175);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        exec.shutdown();
    }

    static void m4(){
        ExecutorService exec = new DaemonThreadPoolExecutor();
        for(int i = 0; i<10; i++){
            exec.execute(new Daemon());
        }
        System.out.println("All daemons started");
        try {
            TimeUnit.MILLISECONDS.sleep(175);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        exec.shutdown();
    }

    public static void main(String[] args) {
//        m();
//        m2();
//        m3();
        m4();
    }

    @Override
    public void run() {
        while(true) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread().getName());
            } catch(InterruptedException e) {
                System.out.println("sleep() interrupted");
            }
        }
    }
}
