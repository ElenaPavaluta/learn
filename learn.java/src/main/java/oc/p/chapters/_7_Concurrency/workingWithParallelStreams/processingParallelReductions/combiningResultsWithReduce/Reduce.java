package oc.p.chapters._7_Concurrency.workingWithParallelStreams.processingParallelReductions.combiningResultsWithReduce;

import java.util.Arrays;
import java.util.List;

/**
 * Although the one- and two-argument versions of reduce()
 * do support parallel processing,
 * it is recommended that you use the three-argument version of reduce()
 * when working with parallel streams.
 * Providing an explicit combiner method allows the JVM to partition
 * the operations in the stream more efficiently
 */
class Reduce {

    static void m() {
        System.out.println(list()
                .stream()
                .reduce("",
                        (newValue, oldValue) -> newValue + oldValue,
                        (s, s2) -> s + s2));
    }

    private static List<Character> list() {
        return Arrays.asList('w', 'o', 'l', 'f');
    }

    static void m2() {
        System.out.println(list().parallelStream()
                .reduce("", (o, n) -> o + n, (s, s2) -> s + s2));
    }

    static void m3() {
        System.out.println(Arrays.asList(1, 2, 3, 4, 5, 6)
                .stream()
                .reduce(0, (a, b) -> a - b));
        /**
         * Breaks associativity
         * (a-b)-c != a - (b-c)
         * (3-2)-1 != 3 - (2 -1)
         */
    }

    static void m4() {
        System.out.println(Arrays.asList(1, 2, 3, 4, 5, 6)
                .parallelStream()
                .reduce(0, (a, b) -> a - b));
    }


    static void m5() {
        System.out.println(Arrays.asList("w", "o", "l", "f")
                .stream()
                .reduce("X", String::concat));

        /**
         * combiner(u, identity) != u
         */
    }

    static void m6() {
        System.out.println(Arrays.asList("w", "o", "l", "f")
                .parallelStream()
                .reduce("X", String::concat));
    }

    public static void main(String[] args) {
//        m();
//        m2();

//        m3();
//        m4();

        m5();
        m6();
    }
}
