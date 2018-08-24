package oc.p.chapters._3_GenericsAndCollections.additionInJava8.usingNewJava8MapApis.compute.tw._1;

import utils.print.Print;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiFunction;

/**
 *  default V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)
 */
class C {

    static Map<Integer, String> map = new TreeMap<>();
    static {
        map.computeIfAbsent(1, String::valueOf);
        map.computeIfAbsent(2, String::valueOf);
        Print.print(map);
    }

    static BiFunction<Integer, String, String> biFunction = (k, v)-> k + " " + v;

    static void m(){
        map.compute(2, biFunction);
        Print.print(map);
    }

    static void m2(){
        map.compute(3, biFunction);  //3 -> 3 null
        Print.print(map);
    }

    static void m3(){
        /**
         * Removes the element as computeIfPresent does
         */
        map.compute(2, (k, v)->null);
        Print.print(map);
    }

    static void m4(){
        //Doesn't do anything
        map.compute(3, (k, v)->null);
        Print.print(map);
    }

    static void m5(){
        map.compute(2, null);
    }

    public static void main(String[] args) {
//        m();
//        m2();
//        m3();
//        m4();
        m5();
    }
}
