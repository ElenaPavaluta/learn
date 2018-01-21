package oc.p.chapters.c_4.workingWithAdvancedStreamPipelineConcepts.collectingResults.collectors.joining;

import java.time.LocalDate;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

/**
 * static Collector<CharSequence,?,String>	joining()
 * Returns a Collector that concatenates the input elements into a String, in encounter order.
 *
 *
 * static Collector<CharSequence,?,String>	joining(CharSequence delimiter)
 * Returns a Collector that concatenates the input elements, separated by the specified delimiter, in encounter order.
 *
 *
 *
 * CharSequence known implementations: CharBuffer, Segment, String, StringBuffer, StringBuilder
 */
class Joining {

    static Stream<LocalDate> stream;

    static void init() {
        stream = Stream.<LocalDate>iterate(LocalDate.now(), ld -> ld.plusDays(1)).limit(7);
    }

    static void m() {
        init();
//        String s = stream.collect(joining());  //compiler error: look at the joining() def

//        String s = stream.map(ld->ld.toString()).collect(joining());  //ok
        String s = stream.map(LocalDate::toString).collect(joining());
        System.out.println(s);
    }

    static void m2() {
        init();
        String s = stream.map(LocalDate::toString).collect(joining(new StringBuilder(" -:- ")));
        System.out.println(s);
    }

    public static void main(String[] args) {
//        m();
        m2();
    }
}
