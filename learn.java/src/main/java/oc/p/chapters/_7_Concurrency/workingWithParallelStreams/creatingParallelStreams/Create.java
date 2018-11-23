package oc.p.chapters._7_Concurrency.workingWithParallelStreams.creatingParallelStreams;

import utils.delimitators.Delimitators;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * S parallel()
 *
 * default Stream<E> parallelStream() -> only for Collection
 */
class Create {

    static void m(){
        IntStream.rangeClosed(1, 10)
                .mapToObj(Integer::new)
                .parallel()
                .forEach(System.out::println);
    }

    static void m2(){
        IntStream.rangeClosed(1, 10)
                .mapToObj(Integer::valueOf)
                .collect(toList())
                .parallelStream()
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        m();
        Delimitators.equal();
        m2();
    }
}
