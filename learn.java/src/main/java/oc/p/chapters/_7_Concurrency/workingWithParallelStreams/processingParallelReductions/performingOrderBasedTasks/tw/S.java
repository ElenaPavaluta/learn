package oc.p.chapters._7_Concurrency.workingWithParallelStreams.processingParallelReductions.performingOrderBasedTasks.tw;

import java.util.stream.Stream;

class S {

    static Stream <Integer> stream() {
        return Stream. <Integer>iterate(1, i -> i + 1);
    }

    static void m() {
        System.out.println(stream().skip(5).limit(2).findFirst().orElse(-1));
    }

    static void m2() {
        System.out.println(stream().parallel().skip(5).limit(2).findFirst().orElse(-1));
    }

    public static void main(String[] args) {
//        m();
        m2();
    }
}
