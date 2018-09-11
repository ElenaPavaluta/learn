package oc.p.chapters._7_Concurrency.workingWithParallelStreams.processingParallelReductions.performingOrderBasedTasks.creatingUnorderedStreams;

import java.util.Arrays;

/**
 * The streams are considered ordered by default, but one can create an unordered one
 *
 * S unordered()
 *
 * This method does not actually reorder the elements;
 * it just tells the JVM that if an order-based stream operation is applied,
 * the order can be ignored.
 * For example, calling skip(5) on an unordered stream will skip any 5 elements,
 * not the first 5 required on an ordered stream.
 */
class Parallel {


    /**
     * For serial streams,
     * using an unordered version has no effect,
     * but on parallel streams, the results can greatly improve performance:
     */
    static void m() {
        Arrays.asList(1, 2, 3, 4, 5, 6).stream().unordered();

        Arrays.asList(1, 2, 3, 4, 5, 6).stream().unordered().parallel();
    }
}
