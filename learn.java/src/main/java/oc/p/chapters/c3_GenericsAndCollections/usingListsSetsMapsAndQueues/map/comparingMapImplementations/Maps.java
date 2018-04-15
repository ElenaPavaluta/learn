package oc.p.chapters.c3_GenericsAndCollections.usingListsSetsMapsAndQueues.map.comparingMapImplementations;

import java.util.*;

class Maps {

    /**
     * stores keys in a hash table: use hashCode() of the keys to retrieve their values more efficiently
     * adding and retrieving happens in constant time
     */
    Map<Integer, String> hashMap = new HashMap<>();

    /**
     * keeps the order in which the elements were inserted
     */
    Map<Integer, String> linkedHashMap  = new LinkedHashMap<>();

    /**
     * stores the keys in a sorted tree structure
     * the keys are always in a sorted order
     * add and checking happens in O(log n)
     */
    Map<Integer, String> treeMap = new TreeMap<>();

    /**
     * really old and Thread safe
     */
    Map<Integer, String> hashtable = new Hashtable<>();
}
