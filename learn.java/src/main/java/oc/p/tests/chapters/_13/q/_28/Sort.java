package oc.p.tests.chapters._13.q._28;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.mapping;

class Sort {
    static void m(){
        List<String> l = Arrays.asList("1", "A", "a");
        Comparator <String> comparator = Comparator.naturalOrder();
        l.sort(comparator);
        System.out.println(l);

        Comparator <String> reversed = comparator.reversed();
        l.sort(reversed);
        System.out.println(l);
    }

    static void m2(){
        String s = Stream. <Character>iterate('1', c -> (char) (c + 1)).limit(62).collect(mapping(String::valueOf, joining()));
        System.out.println(s);
    }

    public static void main(String[] args) {
        m();
        m2();
    }
}
