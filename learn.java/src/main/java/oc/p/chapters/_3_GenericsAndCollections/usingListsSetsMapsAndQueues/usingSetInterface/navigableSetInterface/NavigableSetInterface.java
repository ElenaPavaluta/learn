package oc.p.chapters._3_GenericsAndCollections.usingListsSetsMapsAndQueues.usingSetInterface.navigableSetInterface;

import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class NavigableSetInterface {

    static void m(){
        NavigableSet<Integer> set = new TreeSet<>();
        set = IntStream.rangeClosed(0, 20)
                       .mapToObj(Integer::new)
                       .collect(Collectors.toCollection(TreeSet::new));

        System.out.println(set.lower(10));  //9
        System.out.println(set.floor(10));  //10
        System.out.println(set.ceiling(10));  //10
        System.out.println(set.higher(10));  //11

        System.out.println();
        System.out.println(set.lower(21));  //20
        System.out.println(set.lower(22));  //20
        System.out.println(set.lower(0));  //null

        System.out.println(set.higher(20));  //null
    }

    public static void main(String[] args) {
        m();
    }

}
