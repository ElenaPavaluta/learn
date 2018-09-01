package oc.p.chapters._7_Concurrency.usingConcurrentCollections.workingWithConcurrentClasses.map;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

class Map_ {

    /**
     * -> ConcurrentMap -> Map
     */
    ConcurrentHashMap<Integer, Integer> concurrentHashMap;

    /**
     * ConcurrentNavigableMap -> ConcurrentMap & NavigableMap -> SortedMap
     */
    ConcurrentSkipListMap<Integer, Integer> conurentSkipLisMap;
}
