package oc.p.tests.chapters._20.q._30;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

class Boat {

    void waitTillFinished(CyclicBarrier cb) {
        try {
            cb.await();
            System.out.println("1");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    void row(ExecutorService exec){
        final CyclicBarrier cb = new CyclicBarrier(5);
        IntStream.iterate(1, i->i+1)
                .limit(12)
                .forEach(i->exec.submit(()->waitTillFinished(cb)));
    }

    static void m(){
        ExecutorService exec = null;
        try {
            exec = Executors.newCachedThreadPool();
            new Boat().row(exec);
        }finally {
//            exec.isShutdown();
            exec.shutdown();
        }
    }

    public static void main(String[] args) {
        m();
    }
}
