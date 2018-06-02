package books.thinkigInJava._4ThEdition.chapters.generics.wildcards.tw.assign;

import utils.javaClass.hierrarchy.methods.none.fruit.Apple;
import java.util.List;

class C {

    static List l;
    static List<Object> lo;
    static List<?> lq;
    static List<? extends Apple> lextend;
    static List<? super Apple> lsuper;
    static List<Apple> lst;

    static void m(){
        l = lo;
        l = lq;
        l = lextend;
        l = lsuper;
        l = lst;
    }

    static void m2(){
        lo = l;  //warning

        /**
         * Although Apple extends Fruit
         * List<Fruit> l != List<Apple>
         */
//        lo = lq;  //compiler error

//        lo = lextend;
//        lo = lsuper
//        lo = lst
    }

    static void m3(){
        lq = l;
        lq = lo;
        lq = lextend;
        lq = lsuper;
        lq = lst;
    }

    static void m4(){
        /**
         * OK, don't know why
         */
        lextend = l;  //warning
//        lextend = lo;
//        lextend = lq;
//        lextend  = lsuper;
        lextend = lst;
    }

    static void m5(){
        lsuper =l;  //warning
        lsuper = lo;
//        lsuper = lq;
//        lsuper = lextend
        lsuper = lst;
    }

    static void m6(){
        lst = l;  //warning
//        lst = lo;
//        lst = lq;
        /**
         * Compiler error: it could List<GoldApple>
         * and as we know List<Apple> != List<GoldApple>
         */
//        lst = lextend;

        /**
         * The actual list could be List<Object>
         *  and as we know
         *  List<Apple> != List<Object>
         */
//        lst = lsuper;
    }
}
