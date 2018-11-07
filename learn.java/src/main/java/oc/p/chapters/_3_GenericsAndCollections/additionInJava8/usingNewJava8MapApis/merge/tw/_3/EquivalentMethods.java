package oc.p.chapters._3_GenericsAndCollections.additionInJava8.usingNewJava8MapApis.merge.tw._3;

import java.util.HashMap;
import java.util.Map;

class EquivalentMethods {
    static Map<Integer, Integer> map = new HashMap <>();

    static void putIfAbsent(Integer key, Integer value){
        if(map.get(key) == null){
            map.put(key, value);
        }
        map.putIfAbsent(key, value);
    }
}
