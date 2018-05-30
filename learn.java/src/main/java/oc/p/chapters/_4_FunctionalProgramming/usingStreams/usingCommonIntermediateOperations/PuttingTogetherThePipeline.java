package oc.p.chapters._4_FunctionalProgramming.usingStreams.usingCommonIntermediateOperations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class PuttingTogetherThePipeline {

    static List<String> list = Arrays.asList("Toby", "Anna", "Leroy", "Alex");

    static void m(){
        list.stream()
                .filter(s->s.length()==4)
                .limit(2)
                .sorted()
                .forEach(System.out::println);
    }

    static void m2(){
        Stream.generate(() -> "Elsa")
                .filter(n -> n.length() == 4)
                .sorted()  //since it's a infinite stream the sorted method waits forever
                .limit(2)
                .forEach(System.out::println);
    }

    static void m3(){
        Stream.generate(() -> "Elsa")
                .filter(n -> n.length() == 4)
                .limit(2)
                .sorted()
                .forEach(System.out::println);
    }

    static void m4(){
        Stream.generate(() -> "Olaf Lazisson")
                .filter(n -> n.length() == 4)  //hangs forever, since no element passes the filter method
                .limit(2)
                .sorted()
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
//        m();
//        m2();
//        m3();
    }
}
