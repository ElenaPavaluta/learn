package oc.p.chapters._4_FunctionalProgramming.workingWithAdvancedStreamPipelineConcepts.collectingResults.collectors.groupingBy._2;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.stream.Stream;

class G {

    static Stream<LocalDateTime> stream;

    static void init(){
        stream = Stream.<LocalDateTime>iterate(LocalDateTime.now(), ldt->ldt.plus(Period.of(1, 1, 1)))
                .limit(10);
    }

    static void print(){
        init();
        stream.forEach(System.out::println);
    }

    public static void main(String[] args) {
        print();
    }
}
