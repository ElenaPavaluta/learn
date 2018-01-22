package oc.p.chapters.c_4_FunctionalProgramming.workingWithAdvancedStreamPipelineConcepts.collectingResults.collectors.maxBy_minBy;

import java.time.ZonedDateTime;
import java.util.Comparator;
import java.util.stream.Stream;

import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.minBy;

/**
 * static <T> Collector<T,?,Optional<T>>	maxBy(Comparator<? super T> comparator)
 * Returns a Collector that produces the maximal element according to a given Comparator, described as an Optional<T>.
 *
 * static <T> Collector<T,?,Optional<T>>	minBy(Comparator<? super T> comparator)
 * Returns a Collector that produces the minimal element according to a given Comparator, described as an Optional<T>.
 */
class MaxByMinBy {

    static Stream<Long> longStream;
    static Comparator<Long> comparator = Long::compare;

    static void init() {
        longStream = Stream.generate(ZonedDateTime::now).map(ZonedDateTime::toEpochSecond).limit(5);
    }

    static void m() {
        init();
        longStream.collect(maxBy(comparator)).ifPresent(System.out::println);
    }

    static void m2() {
        init();
        longStream.collect(minBy(comparator)).ifPresent(System.out::println);
    }

    public static void main(String[] args) {
        m();
        m2();
    }
}
