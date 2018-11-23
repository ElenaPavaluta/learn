package oc.p.chapters._7_Concurrency.workingWithParallelStreams.processingParallelReductions.performingOrderBasedTasks.creatingUnorderedStreams;

import utils.delimitators.Delimitators;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * The streams are considered ordered by default, but one can create an unordered one
 *
 * Stream unordered()
 *
 * This method does not actually reorder the elements;
 * it just tells the JVM that if an order-based stream operation is applied,
 * the order can be ignored.
 * For example, calling skip(5) on an unordered stream will skip any 5 elements,
 * not the first 5 required on an ordered stream.
 *
 * For serial streams,
 * using an unordered version has no effect,
 * but on parallel streams, the results can greatly improve performance:
 */
class Parallel {

    static Stream <Integer> intStream() {
        return IntStream.rangeClosed(1, 1000)
                .mapToObj(Integer::new);
    }

    static void m(Stream <Integer> stream) {
        stream.unordered()
                .skip(500)
                .limit(10)
                .skip(5)
                .forEachOrdered(System.out::println);
    }

    static void callM() {
        m(intStream());
        Delimitators.equal();
        m(intStream().parallel());
    }

    public static void main(String[] args) {
        callM();
    }


}
