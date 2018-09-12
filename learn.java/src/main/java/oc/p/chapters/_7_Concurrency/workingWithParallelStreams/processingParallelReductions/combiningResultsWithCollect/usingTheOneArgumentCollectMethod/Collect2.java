package oc.p.chapters._7_Concurrency.workingWithParallelStreams.processingParallelReductions.combiningResultsWithCollect.usingTheOneArgumentCollectMethod;

import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.groupingByConcurrent;
import static java.util.stream.Collectors.toConcurrentMap;

/**
 *         Collectors.toConcurrentMap()
 *
 *         Collectors.groupingByConcurrent()
 */
class Collect2 {

    static void m(){
        Stream<String> onMy = getParallel();

        final ConcurrentMap<Integer, String> collect = onMy.collect(toConcurrentMap(String::length, k -> k, (s, s2) -> s + ", " + s2));
        System.out.println(collect);
        System.out.println(collect.getClass());

        System.out.println(Collectors.toConcurrentMap(null, null).characteristics());
    }

    private static Stream<String> getParallel() {
        return Stream.of("lion", "tigers", "bears").parallel();
    }

    static void m2(){
        final Stream<String> parallel = getParallel();
        final ConcurrentMap<Integer, List<String>> collect = parallel.collect(groupingByConcurrent(String::length));
        System.out.println(collect);
        System.out.println(collect.getClass());
    }

    public static void main(String[] args) {
//        m();
        m2();
    }
}
