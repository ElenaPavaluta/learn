package oc.p.tests.chapters._20.q._37;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

class Q {
    static void m() {
        List <Integer> db = Collections.synchronizedList(new ArrayList <>());

        IntStream.iterate(1, i -> i + 1)
                .limit(5)
                .parallel()
                .map(i -> {
                    db.add(i);
                    return i;
                })
                .forEachOrdered(System.out::print);

        System.out.println();
        db.forEach(System.out::print);
    }

    public static void main(String[] args) {
        m();
    }
}
