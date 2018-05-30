package oc.p.chapters._4_FunctionalProgramming.workingWithPrimitives.creatingPrimitiveStreams.map;

import java.time.LocalDate;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

import static oc.p.chapters._4_FunctionalProgramming.workingWithPrimitives.creatingPrimitiveStreams.map.Util.init;
import static oc.p.chapters._4_FunctionalProgramming.workingWithPrimitives.creatingPrimitiveStreams.map.Util.stream;

class MapStream {


    static void m() {
        init();
        stream.mapToInt(new ToIntFunction<String>() {
            @Override
            public int applyAsInt(String value) {
                return value.length();
            }
        });
    }

    static void m2() {
        init();
        stream.mapToLong(new ToLongFunction<String>() {
            @Override
            public long applyAsLong(String value) {
                return value.length();
            }
        });
    }

    static void m3() {
        init();
        stream.mapToDouble(new ToDoubleFunction<String>() {
            @Override
            public double applyAsDouble(String value) {
                return value.length();
            }
        });
    }

    static void m4() {
        init();
        stream.map(new Function<String, LocalDate>() {
            @Override
            public LocalDate apply(String s) {
                return LocalDate.now();
            }
        });
//        stream.map(s->s);  //Function<String, String>
    }


}
