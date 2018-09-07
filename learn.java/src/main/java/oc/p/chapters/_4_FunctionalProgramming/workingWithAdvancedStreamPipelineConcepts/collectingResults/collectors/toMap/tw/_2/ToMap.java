package oc.p.chapters._4_FunctionalProgramming.workingWithAdvancedStreamPipelineConcepts.collectingResults.collectors.toMap.tw._2;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Stream;

import static java.util.function.UnaryOperator.identity;
import static java.util.stream.Collectors.*;

class ToMap {

    static Stream<LocalDate> stream;

    static void init() {
        stream = Stream.<LocalDate>iterate(LocalDate.now(), ld -> ld.plusYears(1)).limit(5);
    }

    static void m() {
        init();
        final Map<Integer, LocalDate> map = stream.collect(
                toMap(LocalDate::getYear, identity()));
        System.out.println(map);
    }

    static void m2() {
        init();
        final Map<Month, LocalDate> map = stream.collect(
                toMap(LocalDate::getMonth, identity(), (d, d2) -> d.plusMonths(d.getMonthValue())));
        System.out.println(map);
    }

    static void m3(){
        init();
        final HashMap<Integer, LocalDate> map = stream.collect(toMap(LocalDate::getYear, identity(), (d, d2) -> d, HashMap::new));
        System.out.println(map);
    }

    static void m4(){
        init();
        final List<String> collect = stream.collect(
                mapping(LocalDate::toString, mapping(s -> s.split("-")[0], toList())));
        System.out.println(collect);
    }

    static void m5(){
        init();
        final TreeSet<Integer> collect = stream.collect(mapping(LocalDate::toString,
                mapping(s -> s.split("-")[0],
                        mapping(Integer::valueOf, toCollection(TreeSet::new)))));
        System.out.println(collect);
    }

    static void m6(){
        init();
        final IntSummaryStatistics statistics = stream.collect(mapping(LocalDate::getYear, summarizingInt(Integer::intValue)));
        final int max = statistics.getMax();
        System.out.println(max);
    }

    public static void main(String[] args) {
//        print();
//        m();
//        m2();
//        m3();
//        m4();
//        m5();
        m6();
    }


    private static void print() {
        init();
        stream.forEach(System.out::println);
    }
}
