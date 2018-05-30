package oc.p.chapters._4_FunctionalProgramming.usingStreams.usingCommonIntermediateOperations;

import java.util.function.Predicate;
import java.util.stream.Stream;

class Util {

    static Predicate<Integer> smaller = n -> n < 9;
    static Predicate<Integer> greater = n -> n > 0;
    static Predicate<Integer> predicate = greater.and(smaller);

    static Stream<Integer> infinite() {
        return Stream.iterate(1, n -> n + 1);
    }

    static Stream<Integer> finite() {
        return Stream.of(1, 3, 5, 7);
    }

    static Stream<Integer> empty() {
        return Stream.<Integer>empty();
    }
}
