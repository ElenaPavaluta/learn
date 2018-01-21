package oc.p.chapters.c_4.workingWithAdvancedStreamPipelineConcepts.collectingResults.collectors.toCollection;

import java.util.*;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;
/**
 * static <T,C extends Collection<T>>  Collector<T,?,C>	toCollection(Supplier<C> collectionFactory)
 *          Returns a Collector that accumulates the input elements into a new Collection, in encounter order.
 */
class ToCollection {

    static Stream<String> stream;

    static void init() {
        stream = Stream.generate(() -> new Locale("en")).limit(3).map(Locale::getCountry);
    }

    static void m(){
        init();
        List<String> arrayDeque = stream.collect(toCollection(LinkedList::new));
        System.out.println(arrayDeque.getClass());
    }

    static void m2(){
        init();
        Set<String> set = stream.collect(toCollection(TreeSet::new));
        System.out.println(set.getClass());
    }

    static void m3(){
        init();
        Queue<String> queue = stream.collect(toCollection(ArrayDeque::new));
        System.out.println(queue.getClass());
    }

    public static void main(String[] args) {
        m();
        m2();
        m3();
    }
}
