package oc.p.chapters._4_FunctionalProgramming.usingStreams.usingCommonIntermediateOperations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * <R> Stream<R>	flatMap(Function<? super T,? extends Stream<? extends R>> mapper)
 * Returns a stream consisting of the results of replacing each element of this stream
 * with the contents of a mapped stream produced by applying the provided mapping
 * function to each element.
 */
class FlatMap {

    static void m() {
        List<String> zero = Arrays.asList();
        List<String> one = Arrays.asList("Bonobo");
        List<String> two = Arrays.asList("Mama Gorilla", "Baby Gorilla");

        Stream<List<String>> animals = Stream.of(zero, one, two);
        animals.flatMap(List::stream).forEach(System.out::println);
    }

    public static void main(String[] args) {
        m();
    }
}
