package oc.p.chapters._7_Concurrency.managingConcurrentProcesses.applyingTheForkJoinFramework.tw._3;

import java.util.concurrent.RecursiveTask;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.summingLong;

class DoubleNb {

    public static final IntFunction<Long> INT_TO_LONG_FUNCTION = i -> new Long(i * i);
    public static final Predicate<Long> LONG_PREDICATE = l -> l % 37 == 0;
    static int Nb_PROCS = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
        DoubleNb dn = new DoubleNb();
        dn.m();
        dn.m2();
    }

    IntStream stream() {
        return IntStream.rangeClosed(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    void m() {
        long start = System.currentTimeMillis();
        Long collect = stream().mapToObj(INT_TO_LONG_FUNCTION).filter(LONG_PREDICATE).collect(summingLong(Long::longValue));
        System.out.println(collect);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    void m2() {
        long start = System.currentTimeMillis();
        Long collect = stream().parallel().mapToObj(INT_TO_LONG_FUNCTION).filter(LONG_PREDICATE).collect(summingLong(Long::longValue));
        System.out.println(collect);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
