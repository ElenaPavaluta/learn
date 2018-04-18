package oc.p.chapters.c3_GenericsAndCollections.additionInJava8.usingNewJava8MapApis.compute;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * computeIfPresent() calls the BiFunction if the requested key is found
 *
 * computeIfAbsent(), calls the BiFunction  only when the key isn’t present or is null
 */
class Compute {
    Map<String, Integer> map = new HashMap<>();
    BiFunction<String, Integer, Integer> computeIfPresent = (k, v) -> k.length() + v;
    Function<String, Integer> computeIfAbsent= s->s.length()+10;

    {
        map.putIfAbsent("j", 1);
    }

    void m(){
        Integer j = map.computeIfPresent("j", computeIfPresent);
        System.out.println(j);  //2

//        int s = map.computeIfPresent("s", computeIfPresent);  //RE: NPE
        Integer s = map.computeIfPresent("s", computeIfPresent);  //null
        System.out.println(s);
    }

    void m2(){
        map.putIfAbsent(null, 2);
        System.out.println(map);
        System.out.println(map.computeIfAbsent(null, computeIfAbsent));
        System.out.println(map);

        System.out.println(map.computeIfAbsent("a", computeIfAbsent));
        System.out.println(map);
    }

    public static void main(String[] args) {
        Compute c = new Compute();
//        c.m();
        c.m2();
    }
}
