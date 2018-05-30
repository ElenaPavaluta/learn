package oc.p.chapters._4_FunctionalProgramming.usingStreams.usingCommonIntermediateOperations;

import static oc.p.chapters._4_FunctionalProgramming.usingStreams.usingCommonIntermediateOperations.Util.infinite;

/**
 * Stream<T>	peek(Consumer<? super T> action)
 * Returns a stream consisting of the elements of this stream,
 * additionally performing the provided action on each element as elements
 * are consumed from the resulting stream.
 */
class Peek {

    static void m() {
        infinite().peek(System.out::println).limit(5).reduce(Integer::max).ifPresent(System.out::println);
    }

    static void m2(){
        infinite().peek(System.out::println).forEach(System.out::println);
    }

    public static void main(String[] args) {
//        m();
        m2();
    }
}
