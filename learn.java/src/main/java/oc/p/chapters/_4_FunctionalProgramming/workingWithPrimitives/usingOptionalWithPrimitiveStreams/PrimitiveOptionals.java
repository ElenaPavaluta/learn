package oc.p.chapters._4_FunctionalProgramming.workingWithPrimitives.usingOptionalWithPrimitiveStreams;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.LongConsumer;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

class PrimitiveOptionals {

    static IntStream intStream;
    static LongStream longStream;
    static DoubleStream doubleStream;

    static void init() {
        intStream = IntStream.of(1, 2, 3);
        longStream = LongStream.of(1, 2, 3);
        doubleStream = DoubleStream.of(1, 2, 3);
    }

    static void m() {
        init();
        int i = intStream.sum();
        System.out.println(i);

        init();
        OptionalInt optionalInt = intStream.max();
        System.out.println(optionalInt.getAsInt());

        i = optionalInt.orElse(1);
        optionalInt.orElseGet(new IntSupplier() {
            @Override
            public int getAsInt() {
                return 0;
            }
        });
        System.out.println(optionalInt.getAsInt());

        init();
        OptionalDouble optionalDouble = intStream.average();
        optionalDouble.ifPresent(new DoubleConsumer() {
            @Override
            public void accept(double value) {
                System.out.println(value);
            }
        });

        optionalInt.orElseThrow(RuntimeException::new );
    }

    static void m2() {
        init();
        long l = longStream.sum();

        init();
        OptionalDouble optionalDouble = longStream.average();

        init();
        OptionalLong optionalLong = longStream.min();


        init();
        optionalLong = longStream.findFirst();

        init();
        optionalLong = longStream.max();
        optionalLong.ifPresent(new LongConsumer() {
            @Override
            public void accept(long value) {
                System.out.println(value);
            }
        });

        init();
        optionalLong.orElseThrow(RuntimeException::new);

        init();
    }

    static void m3() {
        init();
        double d = doubleStream.sum();

        init();
        OptionalDouble optionalDouble = doubleStream.average();
        optionalDouble.orElseGet(new DoubleSupplier() {
            @Override
            public double getAsDouble() {
                return 1;
            }
        });

        optionalDouble.orElseThrow(RuntimeException::new);
    }
}

