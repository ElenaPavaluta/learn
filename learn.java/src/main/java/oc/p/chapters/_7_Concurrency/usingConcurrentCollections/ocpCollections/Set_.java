package oc.p.chapters._7_Concurrency.usingConcurrentCollections.ocpCollections;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;

import static oc.p.chapters._7_Concurrency.usingConcurrentCollections.ocpCollections.Ocp.TREE_SET;

class Set_ {

    Set <Ocp> set;
    SortedSet <Ocp> sortedSet;
    NavigableSet <Ocp> navigableSet;

    {
        set = new HashSet <>();
        set = new LinkedHashSet <>();
        set = new TreeSet <>();

        set = new CopyOnWriteArraySet();
        set = new ConcurrentSkipListSet <>();

        set = Collections.synchronizedSet(TREE_SET);
        set = Collections.synchronizedSortedSet(TREE_SET);
        set = Collections.synchronizedNavigableSet(TREE_SET);
    }

    {
        sortedSet = new TreeSet <>();

        sortedSet = new ConcurrentSkipListSet <>();

        sortedSet = Collections.synchronizedSortedSet(TREE_SET);
        sortedSet = Collections.synchronizedNavigableSet(TREE_SET);
    }

    {
        navigableSet = new TreeSet <>();

        navigableSet = new ConcurrentSkipListSet <>();

        navigableSet = Collections.synchronizedNavigableSet(TREE_SET);
    }

}
