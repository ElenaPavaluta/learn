package oc.p.chapters._4_FunctionalProgramming.workingWithAdvancedStreamPipelineConcepts.collectingResults.collectors.sumarizing;

import java.util.*;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.summarizingDouble;
import static java.util.stream.Collectors.summarizingLong;

/**
  *
 * static <T> Collector<T,?,IntSummaryStatistics>	summarizingInt(ToIntFunction<? super T> mapper)
 *          Returns a Collector which applies an int-producing mapping function to each input element, and returns summary statistics for the resulting values.
 *
 *
 * static <T> Collector<T,?,LongSummaryStatistics>	summarizingLong(ToLongFunction<? super T> mapper)
 *          Returns a Collector which applies an long-producing mapping function to each input element, and returns summary statistics for the resulting values.
 *
 *
 * static <T> Collector<T,?,DoubleSummaryStatistics>	summarizingDouble(ToDoubleFunction<? super T> mapper)
 *          Returns a Collector which applies an double-producing mapping function to each input element, and returns summary statistics for the resulting values.
 */
class Summarizing {

    static Stream<Locale> localeStream;
    static LongStream longStream;

    static void init() {
        localeStream = Stream.generate(() -> new Locale("en")).limit(3);
    }

    static void initLongStream() {
        longStream = LongStream.rangeClosed(1, 5);
    }

    static void m() {
        init();
        LongSummaryStatistics longSummaryStatistics = localeStream
                .map(Locale::toLanguageTag)
                .collect(summarizingLong(String::length));
        long l = longSummaryStatistics.getSum();
        l = longSummaryStatistics.getMax();
        l = longSummaryStatistics.getMin();
        l = longSummaryStatistics.getCount();
        double d = longSummaryStatistics.getAverage();
        System.out.println(l + " " + d);
    }

    static void m2() {
        init();
        DoubleSummaryStatistics dss = localeStream
                .map(Locale::getCountry)
                .collect(summarizingDouble(String::length));

        long l = dss.getCount();
        double d = dss.getMin();
        d = dss.getMax();
        d = dss.getSum();
        d = dss.getAverage();

        System.out.println(l + " " + d);
    }

    static void m3() {
        initLongStream();
        long l = longStream.count();

        initLongStream();
        l = longStream.sum();

        initLongStream();
        OptionalLong ol = longStream.min();

        initLongStream();
        ol = longStream.max();

        initLongStream();
        OptionalDouble od = longStream.average();

        initLongStream();
        LongSummaryStatistics lss = longStream.summaryStatistics();
    }

    public static void main(String[] args) {
        m();
        m2();
    }


}
