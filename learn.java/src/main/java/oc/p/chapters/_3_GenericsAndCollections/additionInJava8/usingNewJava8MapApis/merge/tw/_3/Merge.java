package oc.p.chapters._3_GenericsAndCollections.additionInJava8.usingNewJava8MapApis.merge.tw._3;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction)
 *
 * V oldValue = map.get(key);
 * V newValue = (oldValue == null) ? value : remappingFunction.apply(oldValue, value);
 * if (newValue == null)
 *      map.remove(key);
 * else
 *      map.put(key, newValue);
 */
class Merge {

    static Map <Integer, Integer> map = new HashMap <>();

    static void equivalentMerge(Integer key, Integer value, BiFunction <Integer, Integer, Integer> remappingFunction) {
        Integer oldVal = map.get(key);
        Integer newVal = (oldVal == null) ? value : remappingFunction.apply(oldVal, value);
        if (newVal == null) {
            map.remove(key);
        } else {
            map.put(key, newVal);
        }
    }
}

