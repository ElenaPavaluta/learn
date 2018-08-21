package oc.p.chapters._3_GenericsAndCollections.additionInJava8.usingNewJava8MapApis.compute.tw._1;

import utils.print.Print;
import java.util.HashMap;
import java.util.Map;

/**
 * default V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction)
 */
class CIA {

    static Map<Integer, String> map = new HashMap<>();
    static {
        map.putIfAbsent(1, "1");
        map.putIfAbsent(2, "2");
        print();
    }

    static void print(){
        map.forEach((k, v)-> System.out.println(k + " -> " +v));
        Print.Delimitators.newLine();
    }

    static void m(){
        System.out.println(map.computeIfAbsent(3, k->String.valueOf(k)));  //3
        print();
    }

    static void m2(){
        System.out.println(map.putIfAbsent(4, null));  //null
        print();

        System.out.println(map.computeIfAbsent(4, String::valueOf));  //4
        print();
    }

    static void m3(){
        System.out.println(map.computeIfAbsent(5, k->null));  //null
        print();
    }

    static void m4(){
        System.out.println(map.computeIfAbsent(6, null));  //NPE
    }

    public static void main(String[] args) {
//        m();
//        m2();
//        m3();
        m4();
    }
}
