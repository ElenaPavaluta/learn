package oc.p.chapters._7_Concurrency.workingWithParallelStreams.processingTasksInParallel.understandingIndependentOperations;

import java.util.Arrays;

class Parallel {

    static void m(){
        Arrays.asList("jackall", "kangaroo", "lemur")
                .parallelStream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    static void m2(){
        Arrays.asList("jackall", "kangaroo", "lemur")
                .parallelStream()
                .map(s->{
                    System.out.println(s);
                    return s.toUpperCase();
                })
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
//        m();
        m2();
    }
}
