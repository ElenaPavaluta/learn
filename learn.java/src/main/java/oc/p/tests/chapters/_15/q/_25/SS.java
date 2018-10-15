package oc.p.tests.chapters._15.q._25;

import java.util.stream.IntStream;
import java.util.stream.Stream;

class SS {

    static void m(){
        IntStream ints = IntStream.empty();
        IntStream moreInts = IntStream.of(66, 77, 88);

        Stream.of(ints, moreInts).flatMapToInt(x->x).forEach(System.out::println);
    }

    public static void main(String[] args) {
        m();
    }
}
