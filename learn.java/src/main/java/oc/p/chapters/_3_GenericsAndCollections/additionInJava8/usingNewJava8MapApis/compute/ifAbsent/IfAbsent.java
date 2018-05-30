package oc.p.chapters._3_GenericsAndCollections.additionInJava8.usingNewJava8MapApis.compute.ifAbsent;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * default V computeIfAbsent(K key, Function<? super K,? extends V> mappingFunction)
 * If the specified key is not already associated with a value
 * (or is mapped to null), - putIfAbsent
 * attempts to compute its value using the given mapping function and enters
 * it into this map unless null.
 *
 * computeIfAbsent(), calls the BiFunction  only when the key isn’t present or is null
 */
class IfAbsent {
    Map<Integer, Integer> map = new HashMap<>();

    {
        map.putIfAbsent(1, 1);
        map.putIfAbsent(2, 2);
    }

    Function<Number, Integer> function = Number::intValue;
    Function<Integer, Integer> nullFunction = n->null;

    void m(){
        map.computeIfAbsent(3, function);
        System.out.println(map);
    }

    void m2() {
        map.putIfAbsent(4, null);
        System.out.println(map);

        map.computeIfAbsent(4, function);
        System.out.println(map);
    }

    void m3(){
        //it just doesn't add the key
        map.computeIfAbsent(3, nullFunction);
        System.out.println(map);
    }

    void m4(){
        map.putIfAbsent(null, null);
        System.out.println(map);

        map.computeIfAbsent(null, function);  //NPE:  can't apply the function on null
    }

    void m5(){
        map.putIfAbsent(3, null);
        System.out.println(map);

        /**
         * Beware: the whole entry isn't removed. it's just unchanged
         */
        map.computeIfAbsent(3, nullFunction);
        System.out.println(map);
    }


    void m6(){
        map.computeIfAbsent(3, null);  //NPE
    }

    public static void main(String[] args) {
        IfAbsent ia = new IfAbsent();

//        ia.m();
//        ia.m2();
//        ia.m3();
//        ia.m4();
//        ia.m5();
        ia.m6();
    }
}
