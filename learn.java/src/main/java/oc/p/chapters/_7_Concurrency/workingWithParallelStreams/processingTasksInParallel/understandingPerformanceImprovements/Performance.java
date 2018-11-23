package oc.p.chapters._7_Concurrency.workingWithParallelStreams.processingTasksInParallel.understandingPerformanceImprovements;

import utils.delimitators.Delimitators;

import java.util.stream.IntStream;

class Performance {

    static void m(IntStream stream) {
        long start = System.currentTimeMillis();
        final long count = stream.mapToObj(Integer::new)
                .filter(i -> i % 2 == 0)
                .filter(i -> i % 13 == 0)
                .count();
        long end = System.currentTimeMillis();
        System.out.println("Duration: " + (end - start));
        System.out.println("Count: " + count);
    }

    static void callM() {
        m(IntStream.rangeClosed(1, Short.MAX_VALUE));
        Delimitators.equal();

        m(IntStream.rangeClosed(1, Short.MAX_VALUE).parallel());
    }

    public static void main(String[] args) {
        callM();
    }
}

