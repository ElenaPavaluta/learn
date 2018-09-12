package oc.p.chapters._3_GenericsAndCollections.usingListsSetsMapsAndQueues.map.tw._1;

import java.util.HashMap;
import java.util.Map;

class M {

    static void m(){
        Map<Integer, Integer> map = new HashMap<>();
        map.putIfAbsent(1, 1);
        map.putIfAbsent(2,2);

        System.out.println(map.getOrDefault(4, null));

    }

    public static void main(String[] args) {
        m();
    }
}
