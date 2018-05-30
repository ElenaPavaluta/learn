package oc.p.chapters._4_FunctionalProgramming.usingStreams.usingCommonIntermediateOperations;
import java.util.Comparator;

import static oc.p.chapters._4_FunctionalProgramming.usingStreams.usingCommonIntermediateOperations.Util.*;

/**
 * Stream<T>	sorted()
 *          Returns a stream consisting of the elements of this stream, sorted according to natural order.
 *
 * Stream<T>	sorted(Comparator<? super T> comparator)
 *          Returns a stream consisting of the elements of this stream,
 *          sorted according to the provided Comparator.
 */
class Sorted {

    static void m(){
        finite().sorted().forEach(System.out::println);
    }

    static void m2(){
        finite().sorted(Integer::compare).forEach(System.out::println);
    }

    static void m3(){
        Comparator<Integer> comparator = Integer::compare;
        comparator = comparator.reversed();
        infinite().limit(10).sorted(comparator).forEach(System.out::println);
    }

    /**
     * Comparator is a functional interface.
     * This means that we can use method references or lambdas to implement it. The
     * Comparator interface implements one method that takes two String parameters and
     * returns an int . However, Comparator::reverseOrder doesn’t do that. It is a reference
     * to a function that takes zero parameters and returns a Comparator .
     */
    static void m4(){
//        finite().sorted(Comparator::reverseOrder)  //
    }

    public static void main(String[] args) {
//        m();
//        m2();
        m3();
    }
}
