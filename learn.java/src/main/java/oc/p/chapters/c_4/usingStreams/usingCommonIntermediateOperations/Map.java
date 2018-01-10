package oc.p.chapters.c_4.usingStreams.usingCommonIntermediateOperations;
import java.util.stream.Stream;

import static oc.p.chapters.c_4.usingStreams.usingCommonIntermediateOperations.Util.*;

/**
 * <R> Stream<R>	map(Function<? super T,? extends R> mapper)
 *
 * Returns a stream consisting of the results of applying the given function to the elements of this stream.
 */

class Map {

    static Stream<Long> stream;

    static void m(){
        stream = infinite().map(Long::new);
        stream.limit(3).forEach(System.out::println);
    }

    static void m2(){
        stream = finite().map(i->new Long(i + 78));
        stream.forEach(System.out::println);
    }

    static void m3(){
        stream = empty().map(Long::valueOf);
        stream.forEach(System.out::println);
    }

    public static void main(String[] args) {
//        m();
//        m2();
        m3();
    }

}
