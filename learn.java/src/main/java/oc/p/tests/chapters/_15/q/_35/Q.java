package oc.p.tests.chapters._15.q._35;

import java.util.*;
import java.util.stream.Stream;

class Q {

    static void m() {
        Set <String> set = new HashSet <>();
        set.add("tire-");
        List <String> lst = new LinkedList <>();
        Deque <String> queue = new ArrayDeque <>();
        queue.push("wheel-");

        Stream.of(set, lst, queue)
                .flatMap(x->x.stream())
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        m();
    }
}
