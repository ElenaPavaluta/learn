package oc.p.chapters._7_Concurrency.synchronizeDataAccess.improvingAccessWithSynchronizedBlocks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class SheepManager {

    private int sheepCount = 0;

    public static void main(String[] args) {
        m();
    }

    private static void m() {
        ExecutorService exec = null;
        try {
            exec = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());
            SheepManager sheepManager = new SheepManager();
            /**
             * This doesn't have any real effect
             *
             * synchronized (sheepManager) means that any thread that
             * wants to access any synchronized method on the sheepManeger
             * instance needs first to acquire the lock/monitor
             * Plus, it's just one thread that's creating threads: the main thread
             */
//            synchronized (sheepManager){
            exec.submit(() -> sheepManager.incrementAndReport());
//            }
        } finally {
            if (exec != null) {
                exec.shutdown();
            }
        }
    }

    void m2(){
        Object object = new Object();
        synchronized (object){
            System.out.println((++sheepCount) + " ");
        }
    }


    private void incrementAndReport() {
        /**
         * Synchronized block: means that any thread that wants to
         * access this block of code, first needs to acquire this
         * object lock/monitor
         */
        synchronized (this) {
            System.out.println((++sheepCount) + " ");
        }
    }
}
