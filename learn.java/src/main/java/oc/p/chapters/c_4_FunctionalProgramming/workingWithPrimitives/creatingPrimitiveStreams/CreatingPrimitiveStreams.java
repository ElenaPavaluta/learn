package oc.p.chapters.c_4_FunctionalProgramming.workingWithPrimitives.creatingPrimitiveStreams;

import java.util.Arrays;
import java.util.function.*;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

class CreatingPrimitiveStreams {

    static IntStream intStream;
    static LongStream longStream;
    static DoubleStream doubleStream;

    static void m(){
        intStream = IntStream.empty();
        intStream = IntStream.of(1, 2);
        intStream = IntStream.generate(()->2);
        intStream = IntStream.iterate(1, new IntUnaryOperator() {
            @Override
            public int applyAsInt(int operand) {
                return 0;
            }
        });
        intStream = Arrays.asList(1, 2, 3).stream().mapToInt(n->n);
        intStream.forEach(System.out::println);
        System.out.println("--");
        intStream = IntStream.range(1, 6);  // 1..5
        intStream.forEach(System.out::println);
        System.out.println("--");
        intStream = IntStream.rangeClosed(1, 6);  // 1..6
        intStream.forEach(System.out::println);
    }

    static void m2(){
        longStream = LongStream.empty();
        longStream = LongStream.of(1, 3);

        longStream = LongStream.iterate(1, new LongUnaryOperator() {
            @Override
            public long applyAsLong(long operand) {
                return operand +1;
            }
        });

        longStream = Arrays.asList(1l, 2l).stream().mapToLong(new ToLongFunction<Long>() {
            @Override
            public long applyAsLong(Long value) {
                return value;
            }
        });

        longStream = LongStream.rangeClosed(1, 6); //1 .. 6
        longStream = LongStream.range(1,6);  // 1 ... 5

    }

    static void m3(){
        doubleStream = DoubleStream.empty();
        doubleStream = DoubleStream.of(1, 2, 3);

        doubleStream = DoubleStream.iterate(1, new DoubleUnaryOperator() {
            @Override
            public double applyAsDouble(double operand) {
                return operand;
            }
        });

//        doubleStream = DoubleStream.rangeClosed()  //doesn't contain this method
//        doubleStream = DoubleStream.range()  //doesn't contains this method either
    }

    public static void main(String[] args) {
        m();
    }
}
