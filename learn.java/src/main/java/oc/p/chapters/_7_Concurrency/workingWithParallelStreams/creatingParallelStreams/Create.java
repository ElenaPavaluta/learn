package oc.p.chapters._7_Concurrency.workingWithParallelStreams.creatingParallelStreams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

class Create {

    static {
        Map<Integer, Integer> map = new HashMap<>();

//        map.parallelStream();
//        map.stream();
    }

    {
        Stream<Integer> stream = Stream.empty();
        System.out.println(stream.isParallel());  //false
    }

    {
        Stream<Integer> stream = Arrays.asList(1, 2, 3, 4, 5).stream();
        Stream<Integer> parallelStream = stream.parallel();

        System.out.println(stream.isParallel());  //true
        System.out.println(parallelStream.isParallel());  //true
    }

    /**
     * only for Collection
     */ {
        Stream<Integer> parallelStream = Arrays.asList(1, 2, 3, 4, 5).parallelStream();
        System.out.println(parallelStream.isParallel());
    }

    public static void main(String[] args) {
        new Create();
    }
}
