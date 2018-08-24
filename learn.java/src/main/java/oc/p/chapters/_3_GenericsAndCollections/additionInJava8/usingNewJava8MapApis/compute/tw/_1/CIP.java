package oc.p.chapters._3_GenericsAndCollections.additionInJava8.usingNewJava8MapApis.compute.tw._1;

import utils.print.Print;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiFunction;

/**
 * default V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)
 */
class CIP {

    static Map<Integer, String> map = new TreeMap<>();
    static BiFunction<Integer, String, String> biFunction = (k, v)->String.valueOf(k) + v;
    static {
        map.putIfAbsent(2, "2");
        map.putIfAbsent(1, "1");
        Print.print(map);
    }

    static void m(){
        System.out.println(map.computeIfPresent(2, biFunction ));  //22
        Print.print(map);
    }

    static void m2(){
        System.out.println(map.computeIfPresent(3, biFunction));  //null;
        Print.print(map);
    }

    static void m3(){
        //Removes the elem
        System.out.println(map.computeIfPresent(2, (k, v)->null));  //null
        Print.print(map);
    }

    static void m4(){
        System.out.println(map.computeIfPresent(3, (k, v)->null));  //null
        Print.print(map);
    }

    static void m5(){
        System.out.println(map.computeIfPresent(2, null));  //NPE
    }

    static void m6(){
        System.out.println(map.computeIfPresent(3, null));  //NPE
    }

    public static void main(String[] args) {
//        m();
//        m2();
//        m3();
//        m4();
//        m5();
        m6();
    }
}
