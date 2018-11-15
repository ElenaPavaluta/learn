package oc.p.chapters._3_GenericsAndCollections.additionInJava8.usingNewJava8MapApis.compute.tw._3;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * V compute(k k, BiFunction<K, V> biFunction){
 *      V  v = map.get(k);
 *     if(v !=null){
 *         return computeIfPresent(k, bifunction)
 *     }else{
 *         Function<K> function = key -> biFunction.apply(key, v);
 *         return computeIfAbsent(k, function)
 *     }
 * }
 *
 * V merge (K k, V v, BinaryOperator<V> bo){
 *     V ov = map.get(k);
 *     V nv = ov == null? v : op.apply(ov, v);
 *     if(nv != null){
 *         map.put(k, nv)
 *     }else{
 *         map.remove(k)
 *     }
 * }
 */
class Compute_ {

    Map <Integer, String> map = new HashMap <>();
    Function<Integer, String> FUNCTION = String::valueOf;
    BiFunction <Integer, String, String> BI_FUNCTION = (k, v) -> String.valueOf(k) + " : " + v;
    BiFunction <Integer, String, String> BI_FUNCTION_2 = (k, v) -> String.valueOf(k) + " : " + v.length();

    void m(){
        System.out.println(map.compute(1, BI_FUNCTION));  //1 : null
    }

    void m2(){
        map.putIfAbsent(2, "2");

        System.out.println(map.compute(2, BI_FUNCTION));  //2 : 2
    }

    void m3(){
        map.computeIfAbsent(3, FUNCTION);

        map.compute(3, (k, v)->null);  // null
        System.out.println(map);
    }

    public static void main(String[] args) {
        Compute_ c= new Compute_();

//        c.m();
//        c.m2();
        c.m3();
    }
}
