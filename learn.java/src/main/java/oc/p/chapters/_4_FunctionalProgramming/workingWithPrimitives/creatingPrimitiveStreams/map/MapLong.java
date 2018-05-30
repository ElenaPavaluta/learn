package oc.p.chapters._4_FunctionalProgramming.workingWithPrimitives.creatingPrimitiveStreams.map;

import java.time.LocalDate;
import java.util.function.LongFunction;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import java.util.function.LongUnaryOperator;

import static oc.p.chapters._4_FunctionalProgramming.workingWithPrimitives.creatingPrimitiveStreams.map.Util.*;

class MapLong {

    static void m(){
        init();
        longStream.mapToInt(new LongToIntFunction() {
            @Override
            public int applyAsInt(long value) {
                return (int)value;
            }
        });
    }

    static void m2(){
        init();
        longStream.map(new LongUnaryOperator() {
            @Override
            public long applyAsLong(long operand) {
                return operand;
            }
        });
    }

    static void m3(){
        init();
        longStream.mapToDouble(new LongToDoubleFunction() {
            @Override
            public double applyAsDouble(long value) {
                return 0;
            }
        });
    }

    static void m4(){
        init();
        longStream.mapToObj(new LongFunction<LocalDate>() {
            @Override
            public LocalDate apply(long value) {
                return LocalDate.now();
            }
        });
    }
}
