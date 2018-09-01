package oc.p.chapters._7_Concurrency.usingConcurrentCollections.workingWithConcurrentClasses.set;

import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;

class Set_ {

    /**
     *  ->Set
     */
    CopyOnWriteArrayList<Integer> copyOnWriteArrayList;

    /**
     * -> NavigableSet -> SortedSet ->Set
     */
    ConcurrentSkipListSet<Integer> concurrentSkipListSet;
}
