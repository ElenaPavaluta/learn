package oc.p.chapters._4_FunctionalProgramming.usingStreams.usingCommonTerminalOperations.count;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * long	count()
 *
 *  infinite stream: does not terminate
 *
 *  reduction: yes
 */
class Count {

    List<Integer> ints = Arrays.asList(1, 2, 3);

    void m(){
        Stream<Integer> intStream = ints.stream();
        System.out.println(intStream.count());
    }

    void infinite(){
        Stream<Double> stream = Stream.generate(Math::random);  //static method reference
        stream.forEach(System.out::println);  //method reference on dbInstance to be determined at runtime
    }

    public static void main(String[] args) {
        Count c = new Count();
//        c.m();
        c.infinite();
    }

}
