package oc.p.chapters._7_Concurrency.workingWithParallelStreams.processingParallelReductions.combiningResultsWithCollect;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Stream;

/**
 * Should use a concurrent collection to combine the results,
 * ensuring that the results of concurrent threads do not cause a
 * ConcurrentModificationException
 */
class Collect {

    static void m(){
        Stream<String> stream = Stream.of("w", "o", "l", "f").parallel();

        /**
         * The rules for concurrent reduce also apply to concurrent collect
         *
         * combiner.apply(u, identity) -> u
         * (a op b) op c = a op (b op c) | op = accumulator
         * combiner.apply(u, accumulator.apply(identity, t)) = accumulator.apply(u, t)
         */
        final ConcurrentSkipListSet<String> collect = stream.collect(
                ConcurrentSkipListSet::new,  // supplier/identity
                Set::add,  //accumulator
                Set::addAll);  //combiner
        System.out.println(collect);
    }

    public static void main(String[] args) {
        m();
    }
}
