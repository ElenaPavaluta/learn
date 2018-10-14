package oc.p.chapters._4_FunctionalProgramming.workingWithPrimitives.tw;

import java.util.function.*;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

class LongPrimitives {

    static void m(LongFunction <Q> longFunction) {
        longFunction.apply(2);
    }

    static void m(ToLongFunction <Q> toLongFunction) {
        toLongFunction.applyAsLong(new Q());
    }

    static void m(ToLongBiFunction <Q, Q> toLongBiFunction) {
        toLongBiFunction.applyAsLong(new Q(), new Q());
    }

    static void m(LongUnaryOperator op) {
        op.applyAsLong(2);
    }

    static void m(LongBinaryOperator op) {
        op.applyAsLong(1, 2);
    }

    static void m(LongSupplier longSupplier) {
        longSupplier.getAsLong();
    }

    static void m(LongConsumer longConsumer) {
        longConsumer.accept(2);
    }

    static void m(ObjLongConsumer <Q> objLongConsumer) {
        objLongConsumer.accept(null, 2);
    }

    static void m(LongPredicate lp) {
        lp.test(2);
    }

    static void m(LongStream longStream) {
        IntStream intStream;
    }

    static class Q {
    }

}
