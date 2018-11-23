package oc.p.chapters._7_Concurrency.workingWithParallelStreams.processingTasksInParallel;

import utils.delimitators.Delimitators;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * void forEachOrdered(Consumer<? super T> action)
 */
class ForEachOrdered {

    static Stream <Integer> integerStream;

    static void init() {
        integerStream = IntStream.rangeClosed(1, 10)
                .mapToObj(Integer::new)
                .parallel();
    }

    static void m() {
        init();
        integerStream.forEach(System.out::println);

        Delimitators.equal();
        init();
        integerStream.forEachOrdered(System.out::println);
    }

    public static void main(String[] args) {
        m();
    }
}
