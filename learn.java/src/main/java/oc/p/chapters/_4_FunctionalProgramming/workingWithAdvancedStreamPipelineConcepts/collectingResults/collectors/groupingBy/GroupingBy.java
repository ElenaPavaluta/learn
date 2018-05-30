package oc.p.chapters._4_FunctionalProgramming.workingWithAdvancedStreamPipelineConcepts.collectingResults.collectors.groupingBy;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * static <T,K> Collector<T,?,Map<K,List<T>>>	groupingBy(Function<? super T,? extends K> classifier)
 *      Returns a Collector implementing a "group by" operation on input elements of type T, grouping elements according to a classification function, and returning the results in a Map.
 *
 * static <T,K,A,D> Collector<T,?,Map<K,D>>	groupingBy(Function<? super T,? extends K> classifier, Collector<? super T,A,D> downstream)
 *      Returns a Collector implementing a cascaded "group by" operation on input elements of type T, grouping elements according to a classification function, and then performing a reduction operation on the values associated with a given key using the specified downstream Collector.
 *
 * static <T,K,D,A,M extends Map<K,D>> Collector<T,?,M>	groupingBy(Function<? super T,? extends K> classifier, Supplier<M> mapFactory, Collector<? super T,A,D> downstream)
 *      Returns a Collector implementing a cascaded "group by" operation on input elements of type T, grouping elements according to a classification function, and then performing a reduction operation on the values associated with a given key using the specified downstream Collector.
 *
 */
class GroupingBy {

    static Stream<String> stream;
    static void init(){
        stream = Stream.of("lions", "tigers", "bears");
    }

    static void m(){
        init();
        Map<Integer, List<String>> map = stream.collect(Collectors.groupingBy(String::length));
        map.forEach((k, v)->System.out.println(k + "->" + v));
    }

    static void m2(){
        init();
        Map<Integer, Set<String>> map = stream.collect(Collectors.groupingBy(String::length, Collectors.toSet()));
        map.forEach((k, v)->System.out.println(k + "->" + v));
    }

    static void m3(){
        init();
        TreeMap<Integer, ArrayDeque<String>> map  =stream.collect(
                Collectors.groupingBy(String::length, TreeMap::new, Collectors.toCollection(ArrayDeque::new)));
        map.forEach((k, v)->System.out.println(k + "->" + v));
    }

    //!!!
    static void m4(){
        init();
        Map<Integer, Long> map = stream.collect(Collectors.groupingBy(String::length, Collectors.counting()));
        map.forEach((k, v)->System.out.println(k + "->" + v));
    }

    public static void main(String[] args) {
        m();
//        m2();
//        m3();
//        m4();
    }
}
