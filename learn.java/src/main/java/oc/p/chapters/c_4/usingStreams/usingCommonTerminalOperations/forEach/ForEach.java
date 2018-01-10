package oc.p.chapters.c_4.usingStreams.usingCommonTerminalOperations.forEach;

import java.util.stream.Stream;

/**
 * void	forEach(Consumer<? super T> action)
 *              Performs an action for each element of this stream.
 *
 * infinite stream: does not terminate
 *
 * reduce: no
 *
 * Remember
 * Can call forEach() directly on a Collection or on a Stream.
 *
 * Notice that you can’t use a traditional for loop on a stream (doesn't implement Iterable interface):
 */
class ForEach {

    static void forEach(){
        Stream<Integer> stream = Stream.iterate(2, n->n+2);
        stream.forEach(System.out::println);
    }

    public static void main(String[] args) {
        forEach();
    }
}
