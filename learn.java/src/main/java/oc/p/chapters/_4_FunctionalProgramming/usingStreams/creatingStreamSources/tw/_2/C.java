package oc.p.chapters._4_FunctionalProgramming.usingStreams.creatingStreamSources.tw._2;

import java.util.stream.Stream;

class C {
    static void m(){
        Stream<String> s = Stream.of();

        System.out.println(s.count());

        Stream<String> s2 = Stream.empty();
//        System.out.println(s2.count());

        System.out.println(s2.allMatch(q->q.endsWith("Bla")));
    }

    public static void main(String[] args) {
        m();
    }
}
