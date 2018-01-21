package oc.p.chapters.c_4.workingWithAdvancedStreamPipelineConcepts.collectingResults.collectors.suming;

import java.util.Locale;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;

/**
 * static <T> Collector<T,?,Double>	summingDouble(ToDoubleFunction<? super T> mapper)
 *      Returns a Collector that produces the sum of a double-valued function applied to the input elements.
 *
 *
 * static <T> Collector<T,?,Integer>	summingInt(ToIntFunction<? super T> mapper)
 *      Returns a Collector that produces the sum of a integer-valued function applied to the input elements.
 *
 *
 * static <T> Collector<T,?,Long>	summingLong(ToLongFunction<? super T> mapper)
 *       Returns a Collector that produces the sum of a long-valued function applied to the input elements.
 */
class Summing {

    static Stream<String> stream;

    static void init() {
        stream = Stream.generate(() -> new Locale("en")).limit(3).map(Locale::getCountry);
    }

    static void m(){
        init();
        int i = stream.collect(summingInt(String::length));
        System.out.println(i);
    }

    static void m2(){
        init();
        long l = stream.collect(summingLong(String::length));
        System.out.println(l);
    }

    static void m3(){
        init();
        double d = stream.collect(summingDouble(String::length));
        System.out.println(d);
    }

    public static void main(String[] args) {
        m();
        m2();
        m3();
    }


}
