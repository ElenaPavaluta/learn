package oc.p.chapters.c_4.workingWithPrimitives.creatingPrimitiveStreams.map;

import java.time.LocalDate;
import java.util.function.DoubleFunction;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.DoubleUnaryOperator;

import static oc.p.chapters.c_4.workingWithPrimitives.creatingPrimitiveStreams.map.Util.*;
class MapDoubleStream {

    static void m(){
        init();
        doubleStream.mapToInt(new DoubleToIntFunction() {
            @Override
            public int applyAsInt(double value) {
                return (int)value;
            }
        });
    }

    static void m2(){
        init();
        doubleStream.mapToLong(new DoubleToLongFunction() {
            @Override
            public long applyAsLong(double value) {
                return (long)value;
            }
        });
    }

    static void m3(){
        init();
        doubleStream.map(new DoubleUnaryOperator() {
            @Override
            public double applyAsDouble(double operand) {
                return operand;
            }
        });
    }

    static void m4(){
        doubleStream.mapToObj(new DoubleFunction<LocalDate>() {
            @Override
            public LocalDate apply(double value) {
                return null;
            }
        });
    }
}
