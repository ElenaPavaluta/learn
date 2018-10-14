package oc.p.tests.chapters._13.q._28;

import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

class TM {

    static TreeMap <Integer, String> treeMap;

    static {
        treeMap = Stream.iterate(1, i -> i + 1)
                .limit(10)
                .collect(toMap(identity(), String::valueOf, (s, s2) -> s2, TreeMap::new));
        System.out.println(treeMap);
    }

    static void m(){
        SortedMap<Integer, String> sm  = treeMap;

        System.out.println(sm.firstKey());
        System.out.println(((TreeMap<Integer, String>) sm).firstEntry());

        System.out.println(sm.lastKey());
        System.out.println(((TreeMap<Integer, String>) sm).lastEntry());
    }

    static void m2(){
        NavigableMap<Integer, String> nm = treeMap;

        System.out.println(nm.floorKey(7));  //7
        System.out.println(nm.lowerKey(7));  //6
        System.out.println(nm.ceilingKey(7));  //7
        System.out.println(nm.higherKey(7));  //8
    }

    public static void main(String[] args) {
//        m();
        m2();
    }
}
