package oc.p.chapters._3_GenericsAndCollections.additionInJava8.usingNewJava8MapApis.compute.ifPresent;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * computeIfPresent() calls the BiFunction if the requested key is found and the associated value is not null
 *
 * default V computeIfPresent(K key, BiFunction<? super K,? super V,? extends V> remappingFunction)
 *  If the value for the specified key is present and non-null,
 *  attempts to compute a new mapping given the key and its current mapped value.
 *
 */
class IfPresent {

    Map<Integer, Integer> map = new HashMap<>();
    {
        map.putIfAbsent(1, 1);
        map.putIfAbsent(2, 2);
    }

    BiFunction<Number, Number, Integer> remapping = (n, n2)->n.intValue() + n2.intValue();
    BiFunction<Integer, Integer, Integer> nullRemapping = (n, n2)->null;

    void m(){
        map.computeIfPresent(1, remapping);
        map.computeIfPresent(2, remapping);
        System.out.println(map);
    }

    /**
     * When the remapping function returns null, the whole entry is deleted
     */
    void m2(){
        map.computeIfPresent(1, nullRemapping);
        map.computeIfPresent(2, nullRemapping);
        System.out.println(map);
    }

    void m3(){
        map.computeIfPresent(1, null);  //RE: NPE
    }

    /**
     * When the key is null, it also throws a NPE: it tries to apply the
     * remapping on null and the current associated value
     */
    void m4(){
        map.putIfAbsent(null, 3);
        System.out.println(map);

        map.computeIfPresent(null, remapping);
        System.out.println(map);

        //the entire entry should be removed
        map.computeIfPresent(null, nullRemapping);
        System.out.println(map);
    }

    void m5(){
        map.computeIfPresent(3, remapping);
        System.out.println(map);

        map.computeIfPresent(3, nullRemapping);
        System.out.println(map);
    }

    void m6(){
        map.putIfAbsent(3, null);
        System.out.println(map);

        map.computeIfPresent(3, remapping);
        System.out.println(map);

        map.computeIfPresent(3, nullRemapping);
        System.out.println(map);
    }

    public static void main(String[] args) {
        IfPresent ip = new IfPresent();

//        ip.m();
//        ip.m2();
//        ip.m3();
//        ip.m4();
//        ip.m5();
        ip.m6();
    }
}
