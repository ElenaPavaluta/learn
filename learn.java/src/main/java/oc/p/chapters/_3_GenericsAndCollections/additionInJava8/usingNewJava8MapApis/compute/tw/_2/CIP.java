package oc.p.chapters._3_GenericsAndCollections.additionInJava8.usingNewJava8MapApis.compute.tw._2;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)
 */
class CIP {

    static Map <Integer, Integer> map = new HashMap <>();
    static BiFunction <Number, Number, Integer> BI_FUNCTION = (n, n2) -> (n.intValue() + n2.intValue()) * 2;
    static BiFunction <Number, Number, Integer> NULL_BI_FUNCTION = (n, n2) -> null;

    static void m() {
        System.out.println(map.computeIfPresent(1, BI_FUNCTION));  //null
        System.out.println(map);
    }

    static void m2(){
        System.out.println(map.putIfAbsent(2, null));
        System.out.println(map);

        System.out.println(map.computeIfPresent(2, BI_FUNCTION));  //null
        System.out.println(map);
    }

    static void m3(){
        System.out.println(map.putIfAbsent(3, 3));
        System.out.println(map);

        System.out.println(map.computeIfPresent(3, BI_FUNCTION));  //12
        System.out.println(map);
    }

    static void m4(){
        System.out.println(map.putIfAbsent(4, 4));  //null
        System.out.println(map);

        //Remove
        System.out.println(map.computeIfPresent(4, NULL_BI_FUNCTION));
        System.out.println(map);
    }

    static void m5(){
        System.out.println(map.putIfAbsent(5, 5));
        System.out.println(map);

        System.out.println(map.computeIfPresent(5, null));  //RE
    }

    public static void main(String[] args) {
//        m();
//        m2();

//        m3();
//        m4();

        m5();
    }
}
