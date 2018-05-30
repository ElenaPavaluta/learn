package oc.p.chapters._4_FunctionalProgramming.workingWithPrimitives.creatingPrimitiveStreams.map;

import java.time.LocalDate;
import java.util.function.IntFunction;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;

import static oc.p.chapters._4_FunctionalProgramming.workingWithPrimitives.creatingPrimitiveStreams.map.Util.*;
class MapIntStream {

    static void m(){
        init();
        intStream.map(new IntUnaryOperator() {
            @Override
            public int applyAsInt(int operand) {
                return operand;
            }
        });
    }

    static void m2(){
        init();
        intStream.mapToLong(new IntToLongFunction() {
            @Override
            public long applyAsLong(int value) {
                return value;
            }
        });
    }

    static void m3(){
        init();
        intStream.mapToDouble(new IntToDoubleFunction() {
            @Override
            public double applyAsDouble(int value) {
                return value;
            }
        });
    }

    static void m4(){
        init();
        intStream.mapToObj(new IntFunction<LocalDate>() {
            @Override
            public LocalDate apply(int value) {
                return LocalDate.now();
            }
        });
    }
}
