package oc.p.chapters._7_Concurrency.managingConcurrentProcesses.creatingACyclicBarrier.tw;

import utils.print.Print;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

class Race {

    private AtomicInteger atomicInteger = new AtomicInteger();
    private Map<Integer, String> progress = new ConcurrentSkipListMap<>();
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(10, () -> {
        Print.Delimitators.equal();
        System.out.println(atomicInteger.getAndIncrement());
        progress.forEach((k, v) -> System.out.println(k + " -> " + v));
    });
    private Random rnd = new Random(47);

    public static void main(String[] args) throws InterruptedException {
        new Race().run();
    }

    void race(ExecutorService executorService) {
        for (int i = 0; i < 10; i++) {
            progress.putIfAbsent(i, "");
            executorService.submit(new Horse(i));
        }
    }

    void run() throws InterruptedException {
        ExecutorService exec = null;
        try {
            exec = Executors.newCachedThreadPool();
            race(exec);
        } finally {
            if (exec != null) exec.shutdown();
        }
    }

    class Horse implements Runnable {
        private int nb;

        Horse(final int nb) {
            this.nb = nb;
        }

        @Override
        public void run() {
            while (atomicInteger.get() < 10) {
                int r = rnd.nextInt(25);
                try {
                    TimeUnit.MILLISECONDS.sleep(r);
                    String nv = IntStream.range(0, r).mapToObj(i -> "*").collect(joining());
                    progress.merge(nb, nv, (s, s2) -> s + s2);
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


