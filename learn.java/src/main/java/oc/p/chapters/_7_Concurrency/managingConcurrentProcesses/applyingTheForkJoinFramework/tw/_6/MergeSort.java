package oc.p.chapters._7_Concurrency.managingConcurrentProcesses.applyingTheForkJoinFramework.tw._6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class MergeSort<E extends Comparable <E>> extends RecursiveTask <List <E>> {

    private static Random rnd = new Random(47);
    private static final Supplier <Integer> GENERATOR = () -> rnd.nextInt(Integer.MAX_VALUE);
    private List <E> list;

    MergeSort(final List <E> list) {
        this.list = list;
    }

    public static void main(String[] args) {
        List <Integer> list = Stream.generate(GENERATOR)
                .limit(10000)
                .collect(toList());
        ForkJoinTask <List <Integer>> task = new MergeSort <>(list);
        ForkJoinPool pool = new ForkJoinPool();
        list = pool.invoke(task);
        list.forEach(System.out::println);
    }

    @Override
    protected List <E> compute() {
        if (list.size() == 1) {
            return list;
        }

        int half = list.size() / 2;
        List <E> a = list.subList(0, half);
        List <E> b = list.subList(half, list.size());

        MergeSort <E> ma = new MergeSort <>(a);
        MergeSort <E> mb = new MergeSort <>(b);

        ma.fork();
        mb.fork();

        a = ma.join();
        b = mb.join();

        return merge(a, b);
    }

    private List <E> merge(final List <E> a, final List <E> b) {
        List <E> res = new ArrayList <>(a.size() + b.size());

        int ai = 0;
        int bi = 0;

        while ((ai < a.size()) && (bi < b.size())) {
            if (a.get(ai).compareTo(b.get(bi)) <= 0) {
                res.add(a.get(ai++));
            } else {
                res.add(b.get(bi++));
            }
        }

        while (ai < a.size()) {
            res.add(a.get(ai++));
        }

        while (bi < b.size()) {
            res.add(b.get(bi++));
        }
        return res;
    }
}
