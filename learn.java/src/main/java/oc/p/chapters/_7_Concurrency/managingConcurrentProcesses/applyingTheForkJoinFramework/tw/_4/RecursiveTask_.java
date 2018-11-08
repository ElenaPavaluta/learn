package oc.p.chapters._7_Concurrency.managingConcurrentProcesses.applyingTheForkJoinFramework.tw._4;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

class RecursiveTask_ extends RecursiveTask <Double> {

    private int start;
    private int end;

    RecursiveTask_(final int start, final int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Double compute() {
        if (end - start <= 10) {
            return IntStream.range(start, end)
                    .mapToDouble(i -> i)
                    .summaryStatistics()
                    .getAverage();
        } else {
            int middle = start + (end - start) / 2;
            RecursiveTask <Double> rt = new RecursiveTask_(start, middle);
            rt.fork();
            RecursiveTask_ rt2 = new RecursiveTask_(middle, end);
            return rt2.compute() + rt.join();
        }
    }

    public static void main(String[] args) {
        ForkJoinTask<Double> forkJoinTask = new RecursiveTask_(0, 10000);
        ForkJoinPool pool = new ForkJoinPool();
        Double invoke = pool.invoke(forkJoinTask);
        System.out.println(invoke);
    }
}
