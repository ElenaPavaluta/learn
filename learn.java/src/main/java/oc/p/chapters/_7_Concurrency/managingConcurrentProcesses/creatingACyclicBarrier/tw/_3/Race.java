package oc.p.chapters._7_Concurrency.managingConcurrentProcesses.creatingACyclicBarrier.tw._3;

import utils.print.Print;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

class Race {
    static final int LAPS = 10;
    static final Random rnd = new Random(47);
    static final AtomicInteger atomicInteger = new AtomicInteger(1);
    private final ConcurrentMap <Integer, String> map = new ConcurrentHashMap <>();
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(LAPS, () ->
    {
        System.out.println(atomicInteger.getAndIncrement());
        Print.print(map);
        Print.Delimitators.newLine();
    });

    public static void main(String[] args) {
        new Race().race();
    }

    void race() {
        ExecutorService exec = null;
        try {
            exec = Executors.newFixedThreadPool(LAPS);
            _race(exec);
        } finally {
            if (exec != null) exec.shutdownNow();
        }
    }

    private void _race(final ExecutorService exec) {
        IntStream.rangeClosed(1, LAPS)
                .mapToObj(i -> new Car(i, map, cyclicBarrier, new Fuel()))
                .forEach(exec::execute);
    }

}

class Fuel implements Callable <String> {
    @Override
    public String call() throws Exception {
        TimeUnit.MILLISECONDS.sleep(Race.rnd.nextInt(50));
        return IntStream.rangeClosed(1, Race.rnd.nextInt(25))
                .mapToObj(i -> "*")
                .collect(joining());
    }
}

class Car implements Runnable {
    private int index;
    private ConcurrentMap <Integer, String> map;
    private ExecutorService exec;
    private CyclicBarrier cyclicBarrier;
    private Fuel fuel;

    Car(final int index, final ConcurrentMap <Integer, String> map, final CyclicBarrier cyclicBarrier, final Fuel fuel) {
        this.index = index;
        this.map = map;
        this.cyclicBarrier = cyclicBarrier;
        this.fuel = fuel;
    }

    @Override
    public void run() {
        try {
            exec = Executors.newSingleThreadExecutor();
            while (Race.atomicInteger.get() < Race.LAPS) {
                try {
                    String value = exec.submit(fuel).get();
                    map.merge(index, value, (o, n) -> o == null ? n : o + n);
                    cyclicBarrier.await();
                } catch (InterruptedException | ExecutionException | BrokenBarrierException e) {
                    System.out.println("Err : " + e.getMessage());
                }
            }
        } finally {
            if (exec != null) exec.shutdownNow();
        }
    }
}
