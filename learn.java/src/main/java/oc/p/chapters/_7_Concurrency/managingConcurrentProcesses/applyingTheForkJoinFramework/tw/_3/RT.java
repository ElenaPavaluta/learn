package oc.p.chapters._7_Concurrency.managingConcurrentProcesses.applyingTheForkJoinFramework.tw._3;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;


class RT extends RecursiveTask<Integer> {
    int start;
    int end;

    public RT(int start, int end) {
        this.start = start;
        this.end = end;
    }

    static void m() {
        ForkJoinTask<Integer> fjt = new RT(0, Integer.MAX_VALUE/10);
        ForkJoinPool pool = new ForkJoinPool();
        Integer sum = pool.invoke(fjt);
        System.out.println(sum);
    }

    public static void main(String[] args) {
        m();
    }

    @Override
    protected Integer compute() {
        if ((end - start) < 20) {
            return IntStream.range(start, end).sum();
        } else {
            int middle = start + (end - start) / 2;
            RecursiveTask<Integer> rt = new RT(start, middle);
            rt.fork();
            return new RT(middle, end).compute() + rt.join();
        }
    }
}
