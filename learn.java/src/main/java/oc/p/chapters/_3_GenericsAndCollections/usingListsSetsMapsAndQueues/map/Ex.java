package oc.p.chapters._3_GenericsAndCollections.usingListsSetsMapsAndQueues.map;

import java.util.*;

class Ex {

    static void m() {
        Map<String, String> map = new HashMap<>();
        map.put("koala", "bamboo");
        map.put("lion", "meat");
        map.put("giraffe", "leaf");
        map.forEach((k, v)-> System.out.println(k + " -> " + v));
    }

    /**
     * TreeMap sorts the keys as we would expect.
     * If we were to have called values() instead
     * of keySet(), the order of the values would correspond to the order
     * of the keys.
     */
    static void m2(){
        Map<String, String> map = new TreeMap<>();
        map.put("koala", "bamboo");
        map.put("lion", "meat");
        map.put("giraffe", "leaf");
        map.forEach((k, v)-> System.out.println(k + " -> " + v));
        System.out.println();
        Set<String> set = map.keySet();
        set.forEach(System.out::println);
        System.out.println();
        Collection<String> c = map.values();
        c.forEach(System.out::println);
}

    public static void main(String[] args) {
//        createAndPopulate();
        m2();
    }
}
