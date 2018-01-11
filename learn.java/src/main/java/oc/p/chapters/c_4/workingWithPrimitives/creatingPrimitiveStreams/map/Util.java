package oc.p.chapters.c_4.workingWithPrimitives.creatingPrimitiveStreams.map;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

class Util {

    static Stream<String> stream;
    static IntStream intStream;
    static LongStream longStream;
    static DoubleStream doubleStream;

    static void init() {
        stream = Stream.of("John", "Doe");
        intStream = IntStream.of(1, 2, 3);
        longStream = LongStream.of(1, 2, 3);
        doubleStream = DoubleStream.of(1, 2, 3);
    }
}
