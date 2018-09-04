package oc.p.chapters._7_Concurrency.usingConcurrentCollections.obtainigSynchronizedCollections;

import java.util.*;

/**
 * Use this when: given an existing collection that is not a
 * concurrent class and needs to access it among multiple threads
 *
 * These methods synchronize access to data elements, such as get() and set();
 * they do not synchronize access on any iterators that have been created
 * from this collections
 *
 * Unlike the concurrent collections,
 * the synchronized collections also throw an exception
 * if they are modified within an iterator by a single thread
 */
class Info {

    private final List<A> aList = Arrays.asList(new A(), new A());
    /**
     * Collection
     */
    Collection<A> collection = Collections.synchronizedCollection(Arrays.asList());
    /**
     * List
     */
    List<A> list = Collections.synchronizedList(aList);
    private NavigableSet<A> asSet = new TreeSet<>();
    /**
     * Set
     */
    Set<A> set = Collections.synchronizedSet(asSet);
    SortedSet<A> sortedSet = Collections.synchronizedSortedSet(asSet);
    NavigableSet<A> navigableSet = Collections.synchronizedNavigableSet(asSet);
    private NavigableMap<A, A> asMap = new TreeMap<>();
    /**
     * Map
     */
    Map<A, A> map = Collections.synchronizedMap(asMap);
    SortedMap<A, A> sortedMap = Collections.synchronizedSortedMap(asMap);
    NavigableMap<A, A> navigableMap = Collections.synchronizedNavigableMap(asMap);

    class A {
    }
}
