package oc.p.chapters._3_GenericsAndCollections.additionInJava8.usingNewJava8MapApis.merge.tw._2;

import utils.print.Print;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * default V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction)
 */
class M {

    static Map<Integer, Double> map = new HashMap<>();
    static {
        map.computeIfAbsent(1, Double::valueOf);
        map.computeIfAbsent(2, Double::valueOf);
        Print.print(map);
    }

    static BiFunction<Double, Double, Double> biFunction = (oldVal, newVal)-> Math.pow(oldVal, newVal);

    static void m(){
        map.merge(2, 3d, biFunction);
        Print.print(map);
    }

    static void m2(){
        /**
         * In this case the bifunction is just not being applied
         */
        map.merge(3, 4d, biFunction);
        Print.print(map);
    }

    static void m3(){
        map.merge(2, 3d, (k, v)->null);  //Removes the value
        Print.print(map);
    }

    static void m4(){
        map.merge(3, 4d, (k, v)->null);  //Just adds the new value
        Print.print(map);
    }

    static void m5(){
        map.merge(2, 3d, null);  //RE
    }

    public static void main(String[] args) {
//        m();
//        m2();
//        m3();
//        m4();
        m5();
    }
}
