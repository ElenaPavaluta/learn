package oc.p.chapters.c3_GenericsAndCollections.additionInJava8.usingNewJava8MapApis.tw;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.TreeMap;

class Data {

    static HashMap<Integer, Integer> hashMap = new HashMap<>();
    static LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
    static Hashtable<Integer, Integer> hashtable = new Hashtable<>();
    static TreeMap<Integer, Integer> treeMap = new TreeMap<>();

    static {
        hashMap.put(1, 1);
        hashMap.put(2, 2);

        linkedHashMap.put(1, 1);
        linkedHashMap.put(2, 2);

        hashtable.put(1, 1);
        hashtable.put(2, 2);

        treeMap.put(1, 1);
        treeMap.put(2, 2);
    }
}

