package oc.p.chapters._4_FunctionalProgramming.workingWithAdvancedStreamPipelineConcepts.collectingResults.collectors.groupingBy._2;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

class G {

    static Stream<LocalDateTime> stream;

    static void init() {
        stream = Stream.<LocalDateTime>iterate(LocalDateTime.now(), ldt -> ldt.plus(Period.of(1, 1, 1)))
                .limit(24);
    }

    static void print() {
        init();
        stream.forEach(System.out::println);
    }

    static void m() {
        init();
        final Map<Month, List<LocalDateTime>> collect = stream.collect(groupingBy(LocalDateTime::getMonth));
        System.out.println(collect);
    }

    static void m2() {
        init();
        final Map<Month, Map<Boolean, List<LocalDateTime>>> collect = stream.collect(groupingBy(LocalDateTime::getMonth, partitioningBy(ldt -> ldt.getYear() % 2 == 0)));
        System.out.println(collect);
    }


    static void m3() {
        init();
        final Map<Month, Map<Boolean, Map<Boolean, List<LocalDateTime>>>> collect = stream.collect(groupingBy(LocalDateTime::getMonth, partitioningBy(ldt -> ldt.getYear() % 2 == 0, partitioningBy(ldt -> ldt.getMonth() == Month.SEPTEMBER))));
        System.out.println(collect);
    }

    static void m4() {
        init();
        final Map<Integer, Map<Month, Map<Integer, Map<Integer, List<LocalDateTime>>>>> collect = stream.collect(groupingBy(LocalDateTime::getYear, groupingBy(LocalDateTime::getMonth, groupingBy(ldt -> ldt.getDayOfMonth(), groupingBy(LocalDateTime::getMinute)))));
        System.out.println(collect);
    }

    static void m5() {
        init();
        final ConcurrentSkipListMap<Integer, Set<Month>> collect = stream.collect(groupingBy(LocalDateTime::getYear, ConcurrentSkipListMap::new, mapping(LocalDateTime::getMonth, toSet())));
        System.out.println(collect);
    }

    public static void main(String[] args) {
//        print();
//        m();
//        m2();
//        m3();
//        m4();
        m5();
    }
}
