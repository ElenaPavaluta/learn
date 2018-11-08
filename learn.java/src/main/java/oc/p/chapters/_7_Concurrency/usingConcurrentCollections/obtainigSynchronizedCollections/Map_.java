package oc.p.chapters._7_Concurrency.usingConcurrentCollections.obtainigSynchronizedCollections;

import java.util.*;

class Map_ {
    final TreeMap <Integer, Integer> TREE_MAP = new TreeMap <>();

    Map <Integer, Integer> map = Collections.synchronizedMap(TREE_MAP);

    SortedMap <Integer, Integer> sortedMap = Collections.synchronizedSortedMap(TREE_MAP);

    NavigableMap <Integer, Integer> navigableMap = Collections.synchronizedNavigableMap(TREE_MAP);
}
