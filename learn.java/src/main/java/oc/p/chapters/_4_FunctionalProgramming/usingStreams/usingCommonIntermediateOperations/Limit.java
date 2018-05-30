package oc.p.chapters._4_FunctionalProgramming.usingStreams.usingCommonIntermediateOperations;
import static oc.p.chapters._4_FunctionalProgramming.usingStreams.usingCommonIntermediateOperations.Util.*;

/**
 * Stream<T>	limit(long maxSize)
 *          Returns a stream consisting of the elements of this stream,
 *          truncated to be no longer than maxSize in length.
 */

class Limit {

    static void m(){
        infinite().limit(3).forEach(System.out::println);
    }

    static void m2(){
        finite().limit(100).forEach(System.out::println);
    }

    static void m3(){
        empty().limit(2).forEach(System.out::println);
    }

    public static void main(String[] args) {
        m();
        m2();
        m3();
    }
}
