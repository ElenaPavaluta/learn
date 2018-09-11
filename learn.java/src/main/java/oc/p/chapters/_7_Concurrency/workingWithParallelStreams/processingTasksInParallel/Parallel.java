package oc.p.chapters._7_Concurrency.workingWithParallelStreams.processingTasksInParallel;

import java.util.Arrays;

/**
 *
 */
class Parallel {

    static void notInParallel(){
        Arrays.asList(1, 2, 3, 4, 5 ,6)
                .stream()
                .forEach(System.out::println);
    }


    static void parallelStream(){
        Arrays.asList(1, 2, 3, 4, 5, 6)
                .parallelStream()
                .forEach(System.out::println);

    }

    static void parallelStreamOrdered(){
        Arrays.asList(1, 2,3, 4, 5, 6)
                .parallelStream()
                .forEachOrdered(System.out::println);
    }

    public static void main(String[] args) {
//        notInParallel();
//        parallelStream();
        parallelStreamOrdered();
    }

}
