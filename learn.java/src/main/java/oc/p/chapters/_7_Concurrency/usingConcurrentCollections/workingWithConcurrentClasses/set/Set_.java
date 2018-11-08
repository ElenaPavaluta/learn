package oc.p.chapters._7_Concurrency.usingConcurrentCollections.workingWithConcurrentClasses.set;

import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;

class Set_ {

    /**
     * ->Set
     */
    CopyOnWriteArraySet <Integer> copyOnWriteArraySet;

    /**
     * -> NavigableSet -> SortedSet ->Set
     */
    ConcurrentSkipListSet <Integer> concurrentSkipListSet;
}
