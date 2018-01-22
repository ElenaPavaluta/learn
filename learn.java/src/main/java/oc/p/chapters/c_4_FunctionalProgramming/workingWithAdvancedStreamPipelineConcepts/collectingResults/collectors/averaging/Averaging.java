package oc.p.chapters.c_4_FunctionalProgramming.workingWithAdvancedStreamPipelineConcepts.collectingResults.collectors.averaging;

import java.time.LocalDateTime;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * static <T> Collector<T,?,Double>	averagingDouble(ToDoubleFunction<? super T> mapper)
 * Returns a Collector that produces the arithmetic mean of a double-valued function applied to the input elements.
 *
 *
 * static <T> Collector<T,?,Double>	averagingInt(ToIntFunction<? super T> mapper)
 * Returns a Collector that produces the arithmetic mean of an integer-valued function applied to the input elements.
 *
 *
 * static <T> Collector<T,?,Double>	averagingLong(ToLongFunction<? super T> mapper)
 * Returns a Collector that produces the arithmetic mean of a long-valued function applied to the input elements.
 */
class Averaging {

    static Stream<LocalDateTime> infinite = Stream.generate(LocalDateTime::now);
    static Stream<LocalDateTime> stream = Stream
            .iterate(LocalDateTime.now(), ldt -> ldt.plusDays(1))
            .limit(3)
            .filter(d -> d.isBefore(d.plusDays(4)));
    static Stream<LocalDateTime> empty = Stream.<LocalDateTime>empty();

    static void m() {
        double d = stream.collect(Collectors.averagingDouble(ldt -> ldt.getDayOfYear()));
        System.out.println(d);
        d = empty.collect(Collectors.averagingDouble(LocalDateTime::getDayOfMonth));
        System.out.println(d);  //0.0
    }

    static void m2() {
//        int i = stream.collect(Collectors.averagingInt(LocalDateTime::getDayOfMonth));  //compiler error: the return type is double

        double d = stream.collect(Collectors.averagingInt(LocalDateTime::getMinute));
        System.out.println(d);
        d = empty.collect(Collectors.averagingInt(LocalDateTime::getMinute));
        System.out.println(d);
    }

    static void m3(){
        ToLongFunction<LocalDateTime> f = LocalDateTime::getMinute;

        double d = stream.collect(Collectors.averagingLong(f));
        System.out.println(d);

        d = empty.collect(Collectors.averagingLong(f));
        System.out.println(d);

    }

    static void m4(){
        ToIntFunction<LocalDateTime> f = LocalDateTime::getMinute;
        double d = infinite.peek(System.out::println).collect(Collectors.averagingInt(f));
        System.out.println(d);
    }

    public static void main(String[] args) {
//        m();
//        m2();
//        m3();
        m4();  //does not terminate
    }

}
