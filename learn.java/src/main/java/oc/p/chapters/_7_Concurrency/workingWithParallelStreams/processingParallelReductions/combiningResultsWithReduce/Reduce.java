package oc.p.chapters._7_Concurrency.workingWithParallelStreams.processingParallelReductions.combiningResultsWithReduce;

import java.util.Arrays;
import java.util.List;

class Reduce {

    static void m() {
        System.out.println(list()
                .stream()
                .reduce("", (newValue, oldValue) -> newValue + oldValue, (s, s2) -> s + s2));
    }

    private static List<Character> list() {
        return Arrays.asList('w', 'o', 'l', 'f');
    }

    static void m2(){
        System.out.println(list().parallelStream()
        .reduce("", (o, n)-> o + n, (s, s2)->s + s2));
    }

    public static void main(String[] args) {
//        m();
        m2();
    }
}
