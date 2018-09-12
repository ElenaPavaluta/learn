package oc.p.chapters._7_Concurrency.managingConcurrentProcesses.creatingACyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * When using a thread pool,
 * make sure that the number of available threads is at least as large
 * as the CyclicBarrier limit value, otherwise the code will hand indefinitely
 */
class LionManager {

    static void notOk() {
        ExecutorService exec = null;
        try {
            exec = Executors.newFixedThreadPool(4);
            LionManager lm = new LionManager();
            for (int i = 0; i < 4; i++) {
                exec.submit(() -> lm.performTask());
            }
        } finally {
            if (exec != null) {
                exec.shutdown();
            }
        }
    }

    static void okWithCyclicBarrier() {
        ExecutorService exec = null;
        try {
            exec = Executors.newFixedThreadPool(4);
            LionManager manager = new LionManager();
            CyclicBarrier cb = new CyclicBarrier(4);
            CyclicBarrier cb2 = new CyclicBarrier(4,
                    () -> System.out.println("*** Pen Cleaned!"));
            for (int i = 0; i < 4; i++) {
                exec.submit(() -> manager.performTask(cb, cb2));
            }
        } finally {
            if (exec != null) exec.shutdown();
        }
    }

    public static void main(String[] args) {
//        notOk();
        okWithCyclicBarrier();
    }

    private void removeAnimals() {
        System.out.println("Removing animals");
    }

    private void cleanPen() {
        System.out.println("Cleaning pen");
    }

    private void addAnimals() {
        System.out.println("Adding animals");
    }

    void performTask() {
        removeAnimals();
        cleanPen();
        addAnimals();
    }

    void performTask(CyclicBarrier cb, CyclicBarrier cb2) {
        try {
            removeAnimals();
            cb.await();
            cleanPen();
            cb2.await();
            addAnimals();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
