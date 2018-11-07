package oc.p.chapters._3_GenericsAndCollections.additionInJava8.usingNewJava8MapApis.compute.tw._2;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

class All {
    static Map <Integer, Integer> map = new HashMap <>();

    static BiFunction <Number, Number, Integer> BI_FUNCTION = (n, n2) -> (n.intValue() + n2.intValue()) * 2;
    static BiFunction <Number, Number, Integer> NULL_BI_FUNCTION = (n, n2) -> null;
    static Function <Number, Integer> FUNCTION = n -> n.intValue() * 2;
    static Function <Number, Integer> NULL_FUNCTION = n -> null;

    static void m() {
        System.out.println(map.computeIfAbsent(1, FUNCTION));  //2
        printAndNewMap();

        System.out.println(map.computeIfPresent(1, BI_FUNCTION));  //null; doesn't add the elem
        printAndNewMap();

//        System.out.println(map.compute(1, BI_FUNCTION));  //RE
    }

    static void m2(){
        System.out.println(map.putIfAbsent(2, null));  //null

        System.out.println(map.computeIfAbsent(2, FUNCTION));  //4
        print();

        System.out.println(map.computeIfPresent(2, BI_FUNCTION));  //12
        print();

        System.out.println(map.compute(2, BI_FUNCTION));  //28
        print();
    }

    static void m3(){
        System.out.println(map.putIfAbsent(3, null));  //null

        System.out.println(map.computeIfAbsent(3, NULL_FUNCTION));  //null; doesn't change anything
        print();

        System.out.println(map.computeIfPresent(3, NULL_BI_FUNCTION));  //null; doesn't change anything
        print();

        System.out.println(map.compute(43, NULL_BI_FUNCTION));  //null; doesn't change anything
        print();
    }

    static void m4(){
        System.out.println(map.putIfAbsent(4, 4));  //null

        System.out.println(map.computeIfAbsent(4, NULL_FUNCTION));  //null, the function isn't applied
        print();

        System.out.println(map.computeIfPresent(4, NULL_BI_FUNCTION));  //null, the entry is removed
        print();

        System.out.println(map.put(44, 44));  //null
        print();

        System.out.println(map.compute(44, NULL_BI_FUNCTION));  //null; the entry is removed
        print();
    }

    static void m5(){
        System.out.println(map.putIfAbsent(5, 5));

//        System.out.println(map.computeIfAbsent(5, null));  //RE
//        System.out.println(map.computeIfPresent(5, null));  //RE
//        System.out.println(map.compute(5, null));  //RE
    }

    public static void main(String[] args) {
//        m();
//        m2();
//        m3();
//        m4();
        m5();
    }

    private static void printAndNewMap() {
        print();
        newMap();
    }

    private static void newMap() {
        map = new HashMap <>();
    }

    private static void print() {
        System.out.println(map);
    }
}
