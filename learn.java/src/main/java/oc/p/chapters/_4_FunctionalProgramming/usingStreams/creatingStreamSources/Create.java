package oc.p.chapters._4_FunctionalProgramming.usingStreams.creatingStreamSources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Create {

    void create(){
        Stream<String> empty = Stream.empty();

        Stream<String> singleElement  =Stream.<String>of("one");
        Stream<Integer> singleElement2 = Stream.of(1);

        Stream<Integer> fromEmptyArray = Stream.<Integer>of();
        Stream<Integer> fromArray = Stream.of(new Integer[]{1, 2, 3,});
        fromArray = Stream.of(1, 2, 3);

        List<String> list = Arrays.asList("a", "b", "c");
        Stream<String> fromList = list.stream();

        Stream<String> fromListParallel = list.parallelStream();

        Stream<Double> randoms = Stream.<Double>generate(Math::random);

        Stream<Integer> oddNumber = Stream.<Integer>iterate(1, n->n+2);
    }
}
