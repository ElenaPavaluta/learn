package oc.p.tests.chapters._15.q._20;

import java.util.Comparator;
import java.util.stream.Stream;

class S {

    static void m() {
        Stream <String> ss = Stream.of("over the river",
                "through the woods",
                "to grandmother's house we go");
        ss.filter(s->s.startsWith("t"))
                .sorted(Comparator.reverseOrder())
                .findFirst()
                .ifPresent(System.out::println);
    }

    public static void main(String[] args) {
        m();
    }
}
