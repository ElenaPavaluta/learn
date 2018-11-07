package oc.p.chapters._3_GenericsAndCollections.additionInJava8.usingNewJava8MapApis.compute.tw._2;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)
 */
class Compute {
    static Map <Integer, Integer> map = new HashMap <>();
    static BiFunction <Number, Number, Integer> BI_FUNCTION = (n, n2) -> (n.intValue() + n2.intValue()) * 2;
    static BiFunction <Number, Number, Integer> NULL_BI_FUNCTION = (n, n2) -> null;

    static void m() {
        System.out.println(map.compute(1, BI_FUNCTION));  //RE
    }

    static void m2(){
        System.out.println(map.compute(2, null));  //RE
    }

    static void m3(){
        System.out.println(map.compute(3, NULL_BI_FUNCTION));  //null;
        System.out.println(map);
    }

    static void m4(){
        System.out.println(map.putIfAbsent(4, 4));
        System.out.println(map);

        System.out.println(map.compute(4, BI_FUNCTION));
        System.out.println(map);
    }

    static void m5(){
        System.out.println(map.putIfAbsent(5, 5));  //null
        System.out.println(map);

        //Remove element
        System.out.println(map.compute(5, NULL_BI_FUNCTION));
        System.out.println(map);
    }

    public static void main(String[] args) {
//        m();
//        m2();

//        m3();
//        m4();

        m5();

    }
}
