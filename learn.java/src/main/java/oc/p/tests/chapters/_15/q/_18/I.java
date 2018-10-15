package oc.p.tests.chapters._15.q._18;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.partitioningBy;

class I {
    static void m() {
        Stream <Boolean> bools = Stream.iterate(true, b -> !b);
        Map <Boolean, List <Boolean>> map = bools.limit(1)
                .collect(partitioningBy(b -> b));
        System.out.println(map);
    }

    public static void main(String[] args) {
        m();
    }
}
