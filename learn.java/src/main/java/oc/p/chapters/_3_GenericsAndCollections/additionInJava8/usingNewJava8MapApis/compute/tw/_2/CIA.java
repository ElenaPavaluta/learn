package oc.p.chapters._3_GenericsAndCollections.additionInJava8.usingNewJava8MapApis.compute.tw._2;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * default V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction)
 */
class CIA {

    static Map <Integer, Integer> map = new HashMap <>();

    static Function <Number, Integer> FUNCTION = n -> n.intValue() * 2;
    static Function <Number, Integer> NULL_FUNCTION = n -> null;

    static void m() {
        System.out.println(map.computeIfAbsent(1, FUNCTION));  //2
        System.out.println(map);
    }

    static void m2() {
        System.out.println(map.putIfAbsent(2, null));  //null
        System.out.println(map.computeIfAbsent(2, FUNCTION));  //4
        System.out.println(map);
    }

    static void m3() {
        /*
        The element isn't added, because the function returns null
         */
        System.out.println(map.computeIfAbsent(3, NULL_FUNCTION));  //null
        System.out.println(map);
    }

    static void m4() {
        System.out.println(map.computeIfAbsent(4, null));  //RE
    }

    static void m5() {
        System.out.println(map.putIfAbsent(5, null));  //null
        System.out.println(map);

        /**
         * Nothing happens
         */
        System.out.println(map.computeIfAbsent(5, NULL_FUNCTION));  //null
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
