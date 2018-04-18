package oc.p.chapters.c3_GenericsAndCollections.additionInJava8.usingNewJava8MapApis;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * default V merge(K key, V value, BiFunction<? super V,? super V,? extends V> remappingFunction)
 *
 * If the specified key is not already associated with a value or
 * is associated with null, associates it with the given non-null value.
 */
class Merge {

    BiFunction<String, String, String> mapper =
            (v, v2) -> v.length() > v2.length() ? v : v2;

    Map<String, String> fav = new HashMap<>();

    {
        fav.put("Jenny", "bus tour");
        fav.put("Tom", "tram");
    }

    public static void main(String[] args) {
        Merge m = new Merge();
//        m.m();
//        m.m2();
//        m.m3();
        m.m4();
    }

    void m() {
        String jenny = fav.merge("Jenny", "skyride", mapper);
        String tom = fav.merge("Tom", "skyride", mapper);

        System.out.println(jenny);  //bus tour
        System.out.println(tom);  //skyride
    }

    void m2() {
        fav.put("Sam", null);

        /**
         * doesn't call the merge function at all
         * in order not to throw a NPE
         */
        fav.merge("Sam", "skyride", mapper);
        fav.merge("Tom", "skyride", mapper);
        System.out.println(fav);

//        fav.merge("Sam", null, mapper);  //NPE
    }

    /**
     * Throws NPE when either of new value or mapper is null
     */
    void m3() {
        /**
         * Ok as long is not a TreeMap-doesn't allow null key
         * or a Hashtable-doesn't allow neither key or null value
         */
        fav.put(null, null);
        System.out.println(fav);

//        fav.merge(null, null, mapper); //NPE
//        fav.merge(null, "not null", null);  //NPE
    }

    /**
     * When the mapper returns null the entry is removed
     */
    void m4() {
        fav.put(null, null);
        System.out.println(fav);

        fav.merge(null, "masina mica", mapper);
        System.out.println(fav);

        BiFunction<String, String, String> merge = (v, v2)->null;

        fav.merge(null, "masina mica si rosie", merge);
        System.out.println(fav);
    }
}
