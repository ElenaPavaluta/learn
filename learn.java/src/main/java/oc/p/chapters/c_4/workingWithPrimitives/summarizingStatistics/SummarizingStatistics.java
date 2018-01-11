package oc.p.chapters.c_4.workingWithPrimitives.summarizingStatistics;

import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.LongSummaryStatistics;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

class SummarizingStatistics {

    static IntStream intStream;
    static LongStream longStream;
    static DoubleStream doubleStream;

    static void init() {
        intStream = IntStream.of(1, 2, 3);
        longStream = LongStream.of(1, 2, 3);
        doubleStream = DoubleStream.of(1, 2, 3);
    }

    static void m(){
        init();
        IntSummaryStatistics summaryStatistics = intStream.summaryStatistics();

        System.out.println(summaryStatistics.getMin());
        System.out.println(summaryStatistics.getMax());
        System.out.println(summaryStatistics.getSum());
        System.out.println(summaryStatistics.getCount());
        System.out.println(summaryStatistics.getAverage());
    }

    static void m2(){
        init();
        LongSummaryStatistics longSummaryStatistics = longStream.summaryStatistics();
    }

    static void m3(){
        init();
        DoubleSummaryStatistics doubleSummaryStatistics = doubleStream.summaryStatistics();
    }

    static void m4(){
        IntStream intStream = IntStream.empty();
        IntSummaryStatistics intSummaryStatistics = intStream.summaryStatistics();

        int min = intSummaryStatistics.getMin();
        int max = intSummaryStatistics.getMax();
        long count = intSummaryStatistics.getCount();
        long sum = intSummaryStatistics.getSum();
        double avg = intSummaryStatistics.getAverage();

        System.out.println(min + " " + " "+ max+ " "+" "+ count+" " + " " + sum + " " + avg);
    }

    public static void main(String[] args) {
        m4();
    }
}
