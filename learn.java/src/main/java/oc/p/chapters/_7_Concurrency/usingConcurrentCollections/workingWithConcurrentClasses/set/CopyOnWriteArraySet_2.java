package oc.p.chapters._7_Concurrency.usingConcurrentCollections.workingWithConcurrentClasses.set;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

class CopyOnWriteArraySet_2 {

    CopyOnWriteArraySet<Integer> set = new CopyOnWriteArraySet<>();
    {
        set.add(1);
        set.add(2);
        set.add(3);
    }


    public static void main(String[] args) {
        CopyOnWriteArraySet_2 c = new CopyOnWriteArraySet_2();

        System.out.println(c.set);
    }

}
