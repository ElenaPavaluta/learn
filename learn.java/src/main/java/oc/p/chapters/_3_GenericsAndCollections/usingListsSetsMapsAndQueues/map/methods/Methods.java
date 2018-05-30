package oc.p.chapters._3_GenericsAndCollections.usingListsSetsMapsAndQueues.map.methods;

import java.util.*;

class Methods {

    static void hashMap(){
        Map<Integer, Integer> map = new HashMap<>();

        System.out.println(map.put(1, 1));  //null

        System.out.println(map.put(null, 1));  //null
        System.out.println(map);
        System.out.println(map.put(2, null));  //null
        System.out.println(map);
        System.out.println(map.put(null, null));  //null
        System.out.println(map);
    }

    static void linkedHashMap(){
        Map<Integer, Integer> map = new LinkedHashMap<>();
        map.put(2,2);
        map.put(null, 1);
        map.put(1, null);
        System.out.println(map);
        map.put(null, null);
        System.out.println(map);
    }

    /**
     * TrreMap doesn't accept null keys (can't compare them)
     * TreeSet doesn't accept null obj (can't compare them)
     * ArrayDeque doesn't accept null obj (use null return value for special cases)
     * Hashtable doesn't accept neither null keys or values
     */
    static void treeMap(){
        Map<Integer, Integer> map = new TreeMap<>();
        map.put(2, 2);
        map.put(1, null);
//        map.put(null, 1);  //RE
        System.out.println(map);
    }

    /**
     * TrreMap doesn't accept null keys (can't compare them)
     * TreeSet doesn't accept null obj (can't compare them)
     * ArrayDeque doesn't accept null obj (use null return value for special cases)
     * Hashtable doesn't accept neither null keys or values
     */
    static void hashtable(){
        Map<Integer, Integer> map = new Hashtable<>();
        map.put(2, 2);
//        map.put(1, null);  //RE
//        map.put(null, 1);  //RE
        System.out.println(map);
    }

    public static void main(String[] args) {
//        hashMap();
//        linkedHashMap();
//        treeMap();
        hashtable();
    }
}
