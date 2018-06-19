package oc.p.chapters._4_FunctionalProgramming.usingStreams.usingCommonTerminalOperations.collect.tw._2;

import oc.p.chapters._9_NIO2.util.TestPath;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.mapping;

/**
 * <R,A> R	collect(Collector<? super T,A,R> collector)
 * Performs a mutable reduction operation on the elements of this stream using a Collector.
 *
 * static <T,U,A,R> Collector<T,?,R>	mapping(Function<? super T,? extends U> mapper, Collector<? super U,A,R> downstream)
 *
 * Adapts a Collector accepting elements of type U to one accepting elements of type T by applying a mapping function
 * to each input element before accumulation.
 */
class Mapping {

    void m(){
        int count = TestPath.pathsThisYear()
            .collect(mapping(p->p.getFileName().toString(), Collectors.toList()))
            .stream().reduce(0, (i, s)->Integer.sum(i, s.length()<14?s.length():0), Integer::sum);
        System.out.println("Paths less the 14 chars: " + count);
    }

    void m2(){
        TestPath.pathsThisYear();
    }

    public static void main(String[] args) {
        Mapping mapping = new Mapping();

        mapping.m();
    }
}
