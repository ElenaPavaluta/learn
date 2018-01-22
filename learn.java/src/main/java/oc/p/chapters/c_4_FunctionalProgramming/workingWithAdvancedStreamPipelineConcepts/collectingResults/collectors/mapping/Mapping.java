package oc.p.chapters.c_4_FunctionalProgramming.workingWithAdvancedStreamPipelineConcepts.collectingResults.collectors.mapping;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * static <T,U,A,R> Collector<T,?,R>	mapping(Function<? super T,? extends U> mapper, Collector<? super U,A,R> downstream)
 * Adapts a Collector accepting elements of type U to one accepting elements of type T by
 * applying a mapping function to each input element before accumulation.
 */
class Mapping {

    static Stream<String> stream;

    static void init() {
        stream = Stream.of("lions", "tigers", "bears");
    }

    static void m() {
        init();
        Map<Integer, Optional<Character>> map = stream.collect(
                Collectors.groupingBy(
                        String::length,
                        Collectors.mapping(s -> s.charAt(0), Collectors.minBy(Comparator.naturalOrder()))));
        System.out.println(map);
    }

    public static void main(String[] args) {
        m();
    }
}
