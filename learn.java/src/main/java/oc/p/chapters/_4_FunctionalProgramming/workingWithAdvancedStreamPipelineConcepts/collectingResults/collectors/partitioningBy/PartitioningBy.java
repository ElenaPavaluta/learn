package oc.p.chapters._4_FunctionalProgramming.workingWithAdvancedStreamPipelineConcepts.collectingResults.collectors.partitioningBy;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * static <T> Collector<T,?,Map<Boolean,List<T>>>	partitioningBy(Predicate<? super T> predicate)
 * Returns a Collector which partitions the input elements according to a Predicate, and organizes them into a Map<Boolean, List<T>>.
 *
 * static <T,D,A> Collector<T,?,Map<Boolean,D>>	partitioningBy(Predicate<? super T> predicate, Collector<? super T,A,D> downstream)
 * Returns a Collector which partitions the input elements according to a Predicate,
 * reduces the values in each partition according to another Collector,
 * and organizes them into a Map<Boolean, D> whose values are the result of the downstream reduction.
 */
class PartitioningBy {

    static Stream<String> stream;
    static Predicate<String> predicate = s->s.length()==5;
    static void init() {
        stream = Stream.of("lions", "tigers", "bears");
    }

    static void m(){
        init();
        Map<Boolean, List<String>> map = stream.collect(Collectors.partitioningBy(predicate));
        map.forEach((k, v)->System.out.println(k + "->" + v));
        System.out.println();
    }

    static void m2(){
        init();
        Map<Boolean, Set<String>> map = stream.collect(Collectors.partitioningBy(predicate, Collectors.toSet()));
        map.forEach((k, v)->System.out.println(k + "->" + v));
        System.out.println();
    }

    //!!!
    static void m3(){
        init();
        Map<Boolean, Long> map = stream.collect(Collectors.partitioningBy(predicate, Collectors.counting()));
        map.forEach((k, v)->System.out.println(k + "->" + v));
        System.out.println();
    }

    public static void main(String[] args) {
//        m();
//        m2();
        m3();
    }
}
