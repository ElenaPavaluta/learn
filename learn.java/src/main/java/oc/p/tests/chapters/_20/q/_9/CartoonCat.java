package oc.p.tests.chapters._20.q._9;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class CartoonCat {

    public static void main(String[] args) {
        new CartoonCat().march(new CyclicBarrier(4, () -> System.out.println("Ready")));
    }

    void await(CyclicBarrier cb) {
        try {
            System.out.println(Thread.currentThread().getId());
            cb.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    void march(CyclicBarrier cb) {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 12; i++) {
            exec.execute(() -> await(cb));
        }
        exec.shutdown();
    }
}
