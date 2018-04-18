package oc.p.chapters.c3_GenericsAndCollections.additionInJava8.loopingThroughaACollection;

import org.omg.PortableInterceptor.INACTIVE;
import java.util.*;

class Loop {

    Collection<String> collection = new TreeSet();
    Map<Integer, String> map = new TreeMap<>();
    {
        collection.add("b");
        collection.add("c");
        collection.add("a");

        map.put(1, "a");
        map.put(3, "c");
        map.put(2, "b");
    }

    void m(){
        Iterator<String> iterator = collection.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println();

        for(String s: collection){
            System.out.println(s);
        }

        System.out.println();

        collection.forEach(System.out::println);
        System.out.println();
    }

    void m2(){
        /**
         * Map doesn't have a iterator method
         */
//        Iterator<Map.Entry<Integer, String>> iterator = map.iterator();

        Set<Map.Entry<Integer, String>> set = map.entrySet();
        Iterator<Map.Entry<Integer, String>> iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println();

        for(Integer i: map.keySet()){
            System.out.println(i + " " + map.get(i));
        }

        System.out.println();

        map.forEach((k, v)-> System.out.println(k + " " + v));
        System.out.println();
    }

    public static void main(String[] args) {
        Loop loop = new Loop();
        loop.m();
        loop.m2();
    }
}
