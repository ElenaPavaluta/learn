package oc.p.chapters._4_FunctionalProgramming.workingWithAdvancedStreamPipelineConcepts.collectingResults.collectors.sumarizing.tw;

import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.LongSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

class SummarizingVsSumming {

    static Stream<Integer> stream;

    static void init(){
        stream = IntStream.rangeClosed(1,10)
                .mapToObj(i->new Integer(i));
    }

    static void m(){
        init();
        final IntSummaryStatistics intSummaryStatistics = stream.collect(summarizingInt(Integer::intValue));

        final int min = intSummaryStatistics.getMin();
        final int max = intSummaryStatistics.getMax();
        final double average = intSummaryStatistics.getAverage();
        final long count = intSummaryStatistics.getCount();
        final long sum = intSummaryStatistics.getSum();

        System.out.println(sum);
    }

    static void m2(){
        init();
        final Integer integer = stream.collect(summingInt(Integer::intValue));
        System.out.println(integer);
    }

    static void m3(){
        init();
        final DoubleSummaryStatistics statistics = stream.map(Integer::doubleValue)
                .collect(summarizingDouble(Double::doubleValue));

        final long count = statistics.getCount();
        final double average = statistics.getAverage();
        final double sum = statistics.getSum();
        final double min = statistics.getMin();
        final double max = statistics.getMax();
        System.out.println(sum);
    }

    static void m4(){
        init();
        final Double collect = stream.map(Integer::doubleValue)
                .collect(summingDouble(Double::doubleValue));
        System.out.println(collect);
    }

    static void m5(){
        init();
        final LongSummaryStatistics statistics = stream.map(Integer::longValue)
                .collect(summarizingLong(Long::longValue));

        final long min = statistics.getMin();
        final long max = statistics.getMax();
        final long count = statistics.getCount();
        final double average = statistics.getAverage();
        final long sum = statistics.getSum();

        System.out.println(sum);
    }

    static void m6(){
        init();
        final Long aLong = stream.map(Integer::longValue)
                .collect(summingLong(Long::longValue));
        System.out.println(aLong);
    }

    public static void main(String[] args) {
//        m();
//        m2();

//        m3();
//        m4();

        m5();
        m6();
    }


}
