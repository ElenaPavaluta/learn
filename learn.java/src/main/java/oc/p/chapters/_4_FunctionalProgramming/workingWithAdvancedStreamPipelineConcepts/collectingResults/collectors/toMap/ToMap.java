package oc.p.chapters._4_FunctionalProgramming.workingWithAdvancedStreamPipelineConcepts.collectingResults.collectors.toMap;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;

/**
 *
 * static <T,K,U> Collector<T,?,Map<K,U>>
 *     toMap(Function<? super T,? extends K> keyMapper,
 *     Function<? super T,? extends U> valueMapper)
 *
 * Returns a Collector that accumulates elements into a Map whose keys and values are the result of
 * applying the provided mapping functions to the input elements.
 *
 *
 * static <T,K,U> Collector<T,?,Map<K,U>>
 *     toMap(Function<? super T,? extends K> keyMapper,
 *     Function<? super T,? extends U> valueMapper,
 *     BinaryOperator<U> mergeFunction
 *
 * Returns a Collector that accumulates elements into a Map whose keys and values are the result of applying the
 * provided mapping functions to the input elements.
 *
 *
 * static <T,K,U,M extends Map<K,U>> Collector<T,?,M>
 *     toMap(Function<? super T,? extends K> keyMapper,
 *     Function<? super T,? extends U> valueMapper,
 *     BinaryOperator<U> mergeFunction,
 *     Supplier<M> mapSupplier)
 *
 * Returns a Collector that accumulates elements into a Map whose keys and values are the result of applying
 * the provided mapping functions to the input elements.
 */
class ToMap {

    static Stream<ZonedDateTime> stream;

    static void init(){
        stream = Stream.<ZonedDateTime>iterate(ZonedDateTime.now(), a->a.plusDays(1))
                .limit(5);
    }

    static void m(){
        init();
        Map<ZonedDateTime, Long> map = stream.collect(toMap(Function.identity(), ZonedDateTime::toEpochSecond));
        map.forEach((k, v)->System.out.println(k + " -> " + v));
        System.out.println(map.getClass());
    }

    static void m2(){
        init();
//        Map<Integer, Long> map = stream.collect(toMap(ZonedDateTime::getYear, ZonedDateTime::toEpochSecond));  //RE - java.lang.IllegalStateException: Duplicate key 1516611498
        Map<Integer, Long> map = stream.collect(toMap(ZonedDateTime::getYear, ZonedDateTime::toEpochSecond, (a, b) ->a.longValue() + b.longValue()));
        map.forEach((k, v)->System.out.println(k + " -> " + v));
        System.out.println(map.getClass());
    }

    static void m3(){
        init();
        Map<Integer, String> map = stream.collect(toMap(ZonedDateTime::getYear, ZonedDateTime::toString, (a, b)-> a + ", " + b, TreeMap::new));
        map.forEach((k, v)->System.out.println(k + " -> " + v));
        System.out.println(map.getClass());
    }

    public static void main(String[] args) {
        m();
        m2();
        m3();
    }


}
