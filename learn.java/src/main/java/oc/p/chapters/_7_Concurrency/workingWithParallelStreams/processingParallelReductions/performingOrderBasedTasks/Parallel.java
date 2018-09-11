package oc.p.chapters._7_Concurrency.workingWithParallelStreams.processingParallelReductions.performingOrderBasedTasks;

import java.util.Arrays;
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

    static void mSeria() {
        System.out.println(stream().findAny().get());
    }

    private static Stream<Integer> stream() {
        return Arrays.asList(1, 2, 3, 4, 5, 6).stream();
    }

    static void mParallel() {
        System.out.println(stream().parallel().findAny().get());
    }

    public static void main(String[] args) {
        mSeria();
        mParallel();
    }
}
