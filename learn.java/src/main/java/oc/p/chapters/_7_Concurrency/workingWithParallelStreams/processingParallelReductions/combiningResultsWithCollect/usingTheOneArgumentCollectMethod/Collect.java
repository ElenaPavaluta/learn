package oc.p.chapters._7_Concurrency.workingWithParallelStreams.processingParallelReductions.combiningResultsWithCollect.usingTheOneArgumentCollectMethod;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

class Collect {

    static void m(){
        System.out.println(getStringStream()
                .collect(toSet()));
    }

    private static Stream<String> getStringStream() {
        return Arrays.asList("w", "o", "l", "f")
                .parallelStream();
    }

    static void m2(){
        System.out.println(getStringStream().isParallel());
    }

    static void m3(){
        final Collector<Object, ?, Set<Object>> collector = Collectors.toSet();
        final Set<Collector.Characteristics> characteristics = collector.characteristics();
        System.out.println(characteristics);
    }

    static void m4(){
        final Collector<Object, ?, List<Object>> collector = Collectors.toList();
        final Set<Collector.Characteristics> characteristics = collector.characteristics();
        System.out.println(characteristics);
    }

    static void m5(){
        final Collector<String, ?, Map<String, Object>> collector = Collectors.toMap((String s) -> s.toUpperCase(), Function.identity());
        final Set<Collector.Characteristics> characteristics = collector.characteristics();
        System.out.println(characteristics);
    }

    static void m6(){
        final Collector<LocalDate, ?, ConcurrentMap<Month, Object>> localDateConcurrentMapCollector = Collectors.toConcurrentMap((LocalDate ld) -> ld.getMonth(), Function.identity());
        final Set<Collector.Characteristics> characteristics = localDateConcurrentMapCollector.characteristics();
        System.out.println(characteristics);
    }



    public static void main(String[] args) {
//        m();
        m2();

//        m3();
//        m4();
//        m5();
//        m6();
    }
}
