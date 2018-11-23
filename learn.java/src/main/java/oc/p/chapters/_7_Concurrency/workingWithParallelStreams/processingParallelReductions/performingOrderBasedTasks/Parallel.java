package oc.p.chapters._7_Concurrency.workingWithParallelStreams.processingParallelReductions.performingOrderBasedTasks;

import utils.delimitators.Delimitators;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Any stream operation that is based on order, including
 * findFirst(),
 * limit(),
 * or skip(),
 * may actually perform more slowly in a parallel environment.
 *
 * This is a result of a parallel processing task being forced to coordinate
 * all of its threads in a synchronized-like fashion.
 *
 * On the plus side, the results of ordered operations on a parallel stream
 * will be consistent with a serial stream. For example, calling
 * skip(5).limit(2).findFirst()
 * will return the same result on ordered serial and parallel streams
 */
class Parallel {


    static Stream <Integer> init() {
        return IntStream.rangeClosed(1, 20)
                .mapToObj(Integer::new);
    }

    static void m(Stream <Integer> s) {
        s.skip(2)
                .limit(10)
                .skip(5)
                .forEachOrdered(System.out::println);
    }

    static void callM() {
        m(init());
        Delimitators.equal();
        m(init().parallel());
    }

    public static void main(String[] args) {
        callM();
    }

}
