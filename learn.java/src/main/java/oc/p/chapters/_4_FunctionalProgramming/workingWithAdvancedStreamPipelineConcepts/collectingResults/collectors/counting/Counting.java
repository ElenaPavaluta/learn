package oc.p.chapters._4_FunctionalProgramming.workingWithAdvancedStreamPipelineConcepts.collectingResults.collectors.counting;

import java.util.DoubleSummaryStatistics;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * static <T> Collector<T,?,Long>	counting()
 * Returns a Collector accepting elements of type T that counts the number of input elements.
 *
 *
 * The IntStream, DoubleStream and LongStream collect method doesn't have an overloaded version which accept a Collectors parameter
 */
class Counting {

    static void m() {
        IntStream intStream = IntStream.rangeClosed(1, 5);
//        long l = intStream.peek(System.out::println).collect(Collectors.counting()); compiler error
        OptionalDouble avg = intStream.average();
        avg.ifPresent(System.out::println);
    }

    static void m2() {
        Stream<Integer> integerStream = Stream.iterate(1, n -> n + 1).limit(5);
        long l = integerStream.peek(System.out::println).collect(Collectors.counting());
        System.out.println(l);
    }

    static void m3() {
        Stream<Double> stream = Stream.generate(Math::random).limit(5);
        Optional<Double> optional = stream.reduce((d, d2) -> d + d2);
        optional.ifPresent(System.out::println);
    }


    static void m4() {
        DoubleStream stream = constructDoubleStream();
        double d = stream.sum();

        stream = constructDoubleStream();
        OptionalDouble od = stream.average();

        stream = constructDoubleStream();
        long l = stream.count();

        stream = constructDoubleStream();
        od = stream.min();

        stream = constructDoubleStream();
        od = stream.max();

        DoubleSummaryStatistics dss = stream.summaryStatistics();
        d = dss.getSum();
        d = dss.getAverage();
        l = dss.getCount();
        d = dss.getMin();
        d = dss.getMax();
    }

    private static DoubleStream constructDoubleStream() {
        return DoubleStream.generate(() -> 2).limit(5);
    }

    public static void main(String[] args) {
//        m();
//        m2();
        m3();
    }

}
