package oc.p.chapters._3_GenericsAndCollections.additionInJava8.usingNewJava8MapApis.compute.tw._3;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

/**
 * V computeIfAbsent(k, Function<K, V>)
 *
 * if (map.get(key) == null) {
 * V newValue = mappingFunction.apply(key);
 * if (newValue != null)
 * map.put(key, newValue);
 * }
 *
 * V computeIfPresent(K, V, BiFunction<K, V, V>)
 *
 * if (map.get(key) != null) {
 *     V oldValue = map.get(key);
 *     V newValue = remappingFunction.apply(key, oldValue);
 *     if (newValue != null)
 *         map.put(key, newValue);
 *     else
 *         map.remove(key);
 * }
 *
 * V compute(K , BiFunction<K, V, V>)
 * V oldValue = map.get(key);
 * V newValue = remappingFunction.apply(key, oldValue);
 * if (oldValue != null ) {
 *    if (newValue != null)
 *       map.put(key, newValue);
 *    else
 *       map.remove(key);
 * } else {
 *    if (newValue != null)
 *       map.put(key, newValue);
 *    else
 *       return null;
 * }
 *
 * V merge(K, V, BinaryOperator<V>)

 */
class EM {

    Map <Integer, String> map = new HashMap <>();
    Function <Integer, String> FUNCTION = String::valueOf;
    BiFunction <Integer, String, String> BI_FUNCTION = (k, v) -> String.valueOf(k) + ": " + String.valueOf(v);
    BinaryOperator<String> BINARY_OPERATOR = (v, v2) -> v + " :: " + v2;

    {
        map.computeIfAbsent(1, FUNCTION);
        map.computeIfAbsent(2, FUNCTION);
    }

    {
        map.computeIfPresent(1, BI_FUNCTION);
        Integer key = null;
        String value = map.get(key);

        if (value == null) {
            String newValue = FUNCTION.apply(key);
            if (newValue != null) {
                map.put(key, newValue);
            }
        }
    }

    {
        Integer key = null;
        String val = map.get(key);
        if(val !=null){
            String newVal = BI_FUNCTION.apply(key, val);
            if(newVal !=null){
                map.put(key, newVal);
            }else{
                map.remove(key);
            }
        }
    }

    {
        Integer key = null;
        String oldValue = map.get(key);
        String newValue = BI_FUNCTION.apply(key, oldValue);
        if(oldValue !=null){
            if(newValue !=null){
                map.put(key, newValue);
            }else{
                map.remove(key);
            }
        }else{
            if(newValue != null){
                map.put(key, newValue);
            }
        }
    }

    {
        Integer key = null;
        String givenVal = null;

        String oldVal = map.get(key);
        String newVal = oldVal == null? givenVal: BINARY_OPERATOR.apply(oldVal, givenVal);

        if(newVal !=null){
            map.put(key, newVal);
        }else{
            map.remove(key);
        }
    }
}
