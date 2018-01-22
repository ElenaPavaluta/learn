package oc.p.chapters.c_4_FunctionalProgramming.usingStreams.usingCommonIntermediateOperations;
import static oc.p.chapters.c_4_FunctionalProgramming.usingStreams.usingCommonIntermediateOperations.Util.*;

/**
 * Stream<T>	skip(long n)
 *              Returns a stream consisting of the remaining elements of this stream after discarding the first
 *              n elements of the stream.
 */
class Skip {
    static void m(){
        infinite().skip(3).limit(3).forEach(System.out::println);
    }

    static void m2(){
        finite().skip(2).forEach(System.out::println);
    }

    static void m3(){
        empty().skip(3).forEach(System.out::println);
    }

    public static void main(String[] args) {
//        m();
//        m2();
        m3();
    }

}
