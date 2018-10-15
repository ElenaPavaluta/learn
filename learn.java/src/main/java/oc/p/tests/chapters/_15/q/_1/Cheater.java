package oc.p.tests.chapters._15.q._1;

import java.util.Arrays;
import java.util.Collection;

class Cheater {

    static int count =0;

    static void sneak(Collection<String> coll){
        coll.stream().peek(System.out::println);
        System.out.println(2);
        coll.stream().peek(System.out::println).findFirst();
        System.out.println(3);
        coll.stream().peek(r->System.out.println(r)).findFirst();
        System.out.println(4);
        coll.stream().peek(r->{
            /**
             * A variable used inside an anonymous class must be final or
             * effective final
             */
//            count++;  //compiler error
        }).findFirst();
    }

    public static void main(String[] args) {
        sneak(Arrays.asList("weasel"));
    }
}
