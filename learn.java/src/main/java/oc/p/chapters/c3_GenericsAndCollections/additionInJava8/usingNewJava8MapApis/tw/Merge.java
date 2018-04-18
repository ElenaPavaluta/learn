package oc.p.chapters.c3_GenericsAndCollections.additionInJava8.usingNewJava8MapApis.tw;

import java.util.function.BiFunction;

import static oc.p.chapters.c3_GenericsAndCollections.additionInJava8.usingNewJava8MapApis.tw.Data.*;

class Merge {

    private static final BiFunction<Integer, Integer, Integer> NULL_MERGE = (i, i2) -> null;
    static BiFunction<Integer, Integer, Integer> merge = (i, i2) -> Integer.max(i, i2);

    static void hashMap() {
        hashMap.putIfAbsent(null, null);
        System.out.println(hashMap);

//        hashMap.merge(null, null, merge);  //NPE
//        hashMap.merge(null, 3, null);  //NPE

        hashMap.putIfAbsent(null, 3);
        System.out.println(hashMap);

        hashMap.merge(null, 33, merge);
        System.out.println(hashMap);

        hashMap.merge(null, 333, NULL_MERGE);
        System.out.println(hashMap);

        hashMap.merge(4, 4, merge);
        System.out.println(hashMap);
    }

    /**
     * Hashtable doesn't accept neither null key nor null value
     */
    static void hashtable() {
//        hashtable.putIfAbsent(null, 3);  //NPE
//        hashtable.putIfAbsent(3, null);  //NPE

        hashtable.putIfAbsent(3, 3);
        hashtable.merge(3, 33, merge);
        System.out.println(hashtable);

        hashtable.merge(3, 333, NULL_MERGE);
        System.out.println(hashtable);
    }

    /**
     * TreeMap doesn't allow null key: it implemets SortedMap which requires it's elements
     * to be of type Comparable and  null isn't Comparable
     */
    static void treeMap() {
        treeMap.putIfAbsent(3, null);
        System.out.println(treeMap);

        treeMap.merge(3, 33, merge);
        System.out.println(treeMap);

        treeMap.merge(3, 333, NULL_MERGE);
        System.out.println(treeMap);
    }

    static void linkedHashMap() {
        linkedHashMap.putIfAbsent(null, null);
        System.out.println(linkedHashMap);

//        linkedHashMap.merge(null,null, merge);  //NPE
//        linkedHashMap.merge(null, 3, null);  //NPE

        linkedHashMap.merge(null, 3, NULL_MERGE);
        System.out.println(linkedHashMap);

        linkedHashMap.merge(4, 4, merge);
        System.out.println(linkedHashMap);

        linkedHashMap.merge(4, 44, NULL_MERGE);
        System.out.println(linkedHashMap);
    }

    public static void main(String[] args) {
//        hashMap();
        linkedHashMap();
//        hashtable();
//        treeMap();
    }
}

