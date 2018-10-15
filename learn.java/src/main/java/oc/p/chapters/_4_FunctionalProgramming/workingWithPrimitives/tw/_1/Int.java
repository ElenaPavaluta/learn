package oc.p.chapters._4_FunctionalProgramming.workingWithPrimitives.tw._1;

import java.util.function.*;
import java.util.stream.IntStream;

class Int {


    static void m(IntFunction <Integer> intFunction) {
        intFunction.apply(10);
    }

    static void m(ToIntFunction <Integer> toIntFunction) {
        toIntFunction.applyAsInt(new Integer(10));
    }

//    static void m(IntBiFunction<Integer, Double> intBiFunction){}

    static void m(ToIntBiFunction <Long, Integer> biFunction) {
        biFunction.applyAsInt(new Long(10), new Integer(10));
    }

    static void m(IntUnaryOperator op) {
        op.applyAsInt(7);
    }

    static void m(IntBinaryOperator op) {
        op.applyAsInt(1, 2);
    }

    static void m(IntSupplier intSupplier) {
        intSupplier.getAsInt();
    }

    static void m(IntConsumer intConsumer) {
        intConsumer.accept(23);
    }

    static void m(ObjIntConsumer <Int> objIntConsumer) {
        objIntConsumer.accept(null, 23);
    }

    static void m(IntToDoubleFunction intToDoubleFunction) {
        intToDoubleFunction.applyAsDouble(2);
    }

    static void m(IntToLongFunction intToLongFunction) {
        intToLongFunction.applyAsLong(2);
    }

    static void m(IntPredicate intPredicate) {
        intPredicate.test(23);
    }

    static void m(IntStream intStream) {
        IntConsumer intConsumer = null;
        intStream.forEach(intConsumer);
    }

}
