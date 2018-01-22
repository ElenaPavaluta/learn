package oc.p.chapters.c_4_FunctionalProgramming.usingStreams.usingCommonIntermediateOperations;

import static oc.p.chapters.c_4_FunctionalProgramming.usingStreams.usingCommonIntermediateOperations.Util.*;

/**
 * Stream<T>	filter(Predicate<? super T> predicate)
 * Returns a stream consisting of the elements of this stream that match the given predicate.
 */
class Filter {

    static void m() {
        infinite().filter(predicate).forEach(System.out::println);
    }

    static void m2() {
        finite().filter(predicate).forEach(System.out::println);
    }

    static void m3() {
        empty().filter(predicate).forEach(System.out::println);
    }

    public static void main(String[] args) {
        m();
//        m2();
//        m3();
    }
}
