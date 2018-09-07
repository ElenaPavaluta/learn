package oc.p.chapters._4_FunctionalProgramming.workingWithAdvancedStreamPipelineConcepts.collectingResults.collectors.mapping;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

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
        final List<String> collect = stream.collect(mapping(String::toUpperCase, toList()));
        collect.forEach(System.out::println);
    }

    static void m2(){
        init();
        final Map<String, String> collect = stream.collect(mapping(String::toUpperCase, toMap(Function.identity(), String::toLowerCase)));
        System.out.println(collect);
    }

    static void m3(){
        init();
        final Map<Integer, String> map = stream.collect(mapping(String::toUpperCase, toMap(String::length, Function.identity(), (s, s2) -> s + " " + s2)));
        System.out.println(map);
    }


    public static void main(String[] args) {
//        m();
//        m2();
        m3();
    }
}
