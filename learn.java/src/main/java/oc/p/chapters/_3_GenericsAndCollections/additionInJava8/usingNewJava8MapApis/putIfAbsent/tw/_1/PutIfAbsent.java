package oc.p.chapters._3_GenericsAndCollections.additionInJava8.usingNewJava8MapApis.putIfAbsent.tw._1;

import java.util.HashMap;
import java.util.Map;

/**
 * default V putIfAbsent(K key, V value)
 */
class PutIfAbsent {
    Map <Integer, Integer> map = new HashMap <>();

    public static void main(String[] args) {
        PutIfAbsent pia = new PutIfAbsent();

        pia.m();
        pia.m2();
        pia.m3();
        pia.m4();
    }

    void m() {
        System.out.println(map.putIfAbsent(1, 1));  //null
        System.out.println(map.putIfAbsent(2, 2));  //null
        System.out.println(map.putIfAbsent(null, null));  //null
        System.out.println(map.putIfAbsent(4, null));  //null
        System.out.println(map);
    }

    void m2(){
        System.out.println(map.putIfAbsent(4, 42));  //null
        System.out.println(map.putIfAbsent(null, 32));   //null
        System.out.println(map);
    }

    void m3(){
        System.out.println(map.putIfAbsent(2, 23));  //2
        System.out.println(map);
    }

    void m4(){
        System.out.println(map.putIfAbsent(null, 33));  //32
        System.out.println(map);
    }

}
