package oc.p.chapters.c_4.workingWithAdvancedStreamPipelineConcepts.collectingResults.collectors.toList_toSet;

import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;

/**
 * static <T> Collector<T,?,List<T>>	toList()
 *      Returns a Collector that accumulates the input elements into a new List.
 *
 *
 * static <T> Collector<T,?,Set<T>>	toSet()
 *      Returns a Collector that accumulates the input elements into a new Set.
 */
class ToListToSet {

    static Stream<String> stream;

    static void init() {
        stream = Stream.generate(() -> new Locale("en")).limit(3).map(Locale::getCountry);
    }

    static void m(){
        init();
        List<String> lst  = stream.collect(Collectors.toList());
        System.out.println(lst.getClass());
    }

    static void m2(){
        init();
        Set<String> set = stream.collect(toSet());
        System.out.println(set.getClass());
    }

    public static void main(String[] args) {
        m();
        m2();
    }
}
