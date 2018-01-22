package oc.p.chapters.c_4_FunctionalProgramming.usingStreams.usingCommonIntermediateOperations;
import static oc.p.chapters.c_4_FunctionalProgramming.usingStreams.usingCommonIntermediateOperations.Util.*;

/**
 * Stream<T>	distinct()
 *
 * Returns a stream consisting of the distinct elements (according to Object.equals(Object)) of this stream.
 */
class Distinct {

    static void m(){
        infinite().distinct().limit(3).forEach(System.out::println);
    }

    static void m2(){
        finite().distinct().forEach(System.out::println);
    }

    static void m3(){
        empty().distinct().forEach(System.out::println);
    }

    public static void main(String[] args) {
//        m();
        m2();
        m3();
    }
}
