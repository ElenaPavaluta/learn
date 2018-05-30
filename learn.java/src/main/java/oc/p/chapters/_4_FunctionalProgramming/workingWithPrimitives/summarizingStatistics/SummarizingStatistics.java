package oc.p.chapters._4_FunctionalProgramming.workingWithPrimitives.summarizingStatistics;

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
        long min = longSummaryStatistics.getMin();
        long max = longSummaryStatistics.getMax();
        long count = longSummaryStatistics.getCount();
        long sum = longSummaryStatistics.getSum();
        double avg = longSummaryStatistics.getAverage();
    }

    static void m3(){
        init();
        DoubleSummaryStatistics doubleSummaryStatistics = doubleStream.summaryStatistics();
        double min = doubleSummaryStatistics.getMin();
        double max = doubleSummaryStatistics.getMax();
        long count = doubleSummaryStatistics.getCount();
        double sum = doubleSummaryStatistics.getSum();
        double avg = doubleSummaryStatistics.getAverage();
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
