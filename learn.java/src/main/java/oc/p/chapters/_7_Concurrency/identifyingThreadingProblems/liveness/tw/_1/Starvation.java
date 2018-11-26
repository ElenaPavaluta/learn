package oc.p.chapters._7_Concurrency.identifyingThreadingProblems.liveness.tw._1;

import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

class Starvation {

    static int ITERATIONS = 10;
    static Starvation starvation = new Starvation();
    static Cabbage cabbage = starvation.new Cabbage();
    static CyclicBarrier cb = new CyclicBarrier(6, () -> cabbage.reset());

    static void m() {
        final List <Rabbit> list = IntStream.rangeClosed(1, 5)
                .mapToObj(i -> starvation.new Rabbit(cb, cabbage))
                .collect(toList());

        ExecutorService execR = Executors.newFixedThreadPool(5, starvation.new RabbitFactory());
        ExecutorService execT = Executors.newSingleThreadExecutor(starvation.new TortoiseFactory());

        execT.execute(starvation.new Tortoise(cb, cabbage));
        list.forEach(execR::submit);

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {

        }
        execR.shutdown();
        execT.shutdown();
    }

    public static void main(String[] args) {
        m();
    }


    class Cabbage {
        private AtomicInteger amount = new AtomicInteger(5);

        synchronized int get() {
            if (amount.get() > 0) {
                amount.getAndDecrement();
                return 1;
            } else {
                return 0;
            }
        }

        synchronized void reset() {
            amount.set(5);
        }
    }

    class Rabbit implements Runnable {
        private int eaten = 0;
        private int tries = 0;
        private CyclicBarrier cb;
        private Cabbage cabbage;

        Rabbit(final CyclicBarrier cb, final Cabbage cabbage) {
            this.cb = cb;
            this.cabbage = cabbage;
        }

        @Override
        public void run() {
            for (int i = 0; i < ITERATIONS; i++) {
                eaten += cabbage.get();
                tries++;
                try {
                    cb.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                }
            }
            System.out.println(this.getClass().getSimpleName() + ": " + Thread.currentThread().getId() + "| tries: " + tries + " | eaten: " + eaten);
        }
    }

    class Tortoise implements Runnable {
        private int eaten = 0;
        private int tries = 0;
        private CyclicBarrier cyclicBarrier;
        private Cabbage cabbage;

        Tortoise(final CyclicBarrier cyclicBarrier, final Cabbage cabbage) {
            this.cyclicBarrier = cyclicBarrier;
            this.cabbage = cabbage;
        }

        @Override
        public void run() {
            for (int i = 0; i < ITERATIONS; i++) {
                try {
                    TimeUnit.MILLISECONDS.sleep(50);
                } catch (InterruptedException e) {
                }
                eaten += cabbage.get();
                tries++;
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(this.getClass().getSimpleName() + ": " + Thread.currentThread().getId() + "| tries: " + tries + " | eaten: " + eaten);
        }
    }

    class TortoiseFactory implements ThreadFactory {
        @Override
        public Thread newThread(final Runnable r) {
            Thread t = new Thread(r);
            t.setPriority(Thread.MIN_PRIORITY);
            return t;
        }
    }

    class RabbitFactory implements ThreadFactory {
        @Override
        public Thread newThread(final Runnable r) {
            Thread t = new Thread(r);
            t.setPriority(Thread.MAX_PRIORITY);
            return t;
        }
    }
}
