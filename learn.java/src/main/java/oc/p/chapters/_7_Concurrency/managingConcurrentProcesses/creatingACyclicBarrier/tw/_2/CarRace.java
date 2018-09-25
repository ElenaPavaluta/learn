package oc.p.chapters._7_Concurrency.managingConcurrentProcesses.creatingACyclicBarrier.tw._2;

import utils.print.Print;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

class CarRace {

    static int NB = 10;
    Map<Integer, String> map =
            IntStream.rangeClosed(1, NB)
                    .mapToObj(Integer::valueOf)
                    .collect(toConcurrentMap(Function.identity(), String::valueOf));

    CyclicBarrier cyclicBarrier = new CyclicBarrier(10, () -> {
        map.values().forEach(System.out::println);
        Print.Delimitators.equal();
    });


    Random rnd = new Random(47);

    public static void main(String[] args) {
        CarRace race = new CarRace();
        race.m();
    }

    void m() {
        ExecutorService exec = null;
        try {
            exec = Executors.newFixedThreadPool(NB);
            IntStream.rangeClosed(1, NB).mapToObj(Car::new).collect(toList()).forEach(exec::submit);
        } finally {
            if (exec != null) exec.shutdown();
        }
    }

    class Car implements Runnable {
        StringBuilder stringBuilder = new StringBuilder();
        private int index;

        public Car(int index) {
            this.index = index;
        }

        @Override
        public void run() {
            for (int i = 0; i < NB; i++) {
                try {
                    String s = IntStream.range(0, rnd.nextInt(25)).mapToObj(k -> "*").collect(joining(""));
                    map.merge(index, s, (ov, nv) -> ov + nv);
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
