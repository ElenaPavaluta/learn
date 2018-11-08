package oc.p.chapters._7_Concurrency.usingConcurrentCollections.obtainigSynchronizedCollections;

import java.util.*;

class Set_ {
    final TreeSet <Integer> TREE_SET = new TreeSet <>();

    Set <Integer> set = Collections.synchronizedSet(TREE_SET);

    SortedSet <Integer> sortedSet = Collections.synchronizedSortedSet(TREE_SET);

    NavigableSet <Integer> navigableSet = Collections.synchronizedNavigableSet(TREE_SET);
}
