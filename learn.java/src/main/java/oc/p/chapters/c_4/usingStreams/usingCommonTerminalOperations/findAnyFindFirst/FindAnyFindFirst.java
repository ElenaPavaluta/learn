package oc.p.chapters.c_4.usingStreams.usingCommonTerminalOperations.findAnyFindFirst;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

/**
 *
 * Optional<T>	findAny()
 *          Returns an Optional describing some element of the stream,
 *          or an empty Optional if the stream is empty.
 *          - Useful with parallel streams
 *
 * Optional<T>	findFirst()
            Returns an Optional describing the first element of this stream,
            or an empty Optional if the stream is empty.
 *
 * infinite stream: terminate
 *
 * reduce: yes
 */
class FindAnyFindFirst {

    static Stream<Long> stream = Arrays.asList(1l, 2l, 3l, 4l).stream();
    static Stream<Long> empty = Stream.of();
    static Optional<Long> optional;

    static void findAny(){
        optional = stream.findAny();
        optional.ifPresent(System.out::println);

        optional= empty.findAny();
        optional.ifPresent(System.out::println);
    }

    static void findFirst(){
        optional = stream.findFirst();
        optional.ifPresent(System.out::println);

        optional = empty.findFirst();
        optional.ifPresent(System.out::println);
    }

    public static void main(String[] args) {
//        findAny();
        findFirst();
    }

}
