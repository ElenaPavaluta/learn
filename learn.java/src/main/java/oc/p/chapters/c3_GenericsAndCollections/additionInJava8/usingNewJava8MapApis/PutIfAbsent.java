package oc.p.chapters.c3_GenericsAndCollections.additionInJava8.usingNewJava8MapApis;

import java.util.HashMap;

/**
 * V put(K key, V value)
 *
 * default V putIfAbsent(K key, V value)
 *
 * If the specified key is not already associated with a value
 * (or is mapped to null) associates it with the given value and
 * returns null, else returns the current value
 */
class PutIfAbsent {

    static HashMap<Integer, Integer> hashMap = new HashMap<>();

    static {
        hashMap.put(1, 1);
        hashMap.put(2, 2);
    }

    static void m() {
        hashMap.putIfAbsent(null, null);
        System.out.println(hashMap);

        hashMap.putIfAbsent(null, 5);
        System.out.println(hashMap);

        System.out.println(hashMap.putIfAbsent(3, null));
        System.out.println(hashMap);

        System.out.println(hashMap.putIfAbsent(3, 3));
        System.out.println(hashMap);

        System.out.println(hashMap.putIfAbsent(2, 22));  //returns the current value associated with the given key
        System.out.println(hashMap);
    }

    public static void main(String[] args) {
        m();
    }
}
