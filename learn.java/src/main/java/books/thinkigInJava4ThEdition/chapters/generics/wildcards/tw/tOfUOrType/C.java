package books.thinkigInJava4ThEdition.chapters.generics.wildcards.tw.tOfUOrType;

import books.thinkigInJava4ThEdition.chapters.generics.wildcards.Holder;
import utils.generalUse.hierrarchy.noMethods.fruit.Apple;
import java.util.List;

/**
 * A<B<U>>
 */
class C {

    static Holder h;
    static Holder<List> hl;
    static Holder<List<Object>> hlo;
    static Holder<List<?>> hlq;
    static Holder<List<? extends Apple>> hlextend;
    static Holder<List<? super Apple>> hlsuper;
    static Holder<List<Apple>> hlapple;

    static void m(){
        h = hl;
        h = hlo;
        h = hlq;
        h = hlextend;
        h = hlsuper;
        h = hlapple;
    }

    static void m2(){
        hl = h;
//        hl = hlo;  //compiler error
//        hl = hlq;
//        hl = hlextend;
//        hl = hlsuper;
//        hl = hlapple;
    }

    static void m3(){
        hlo = h;
//        hlo = hl;
//        hlo = hlq
//        hlo = hlextend;
//        hlo = hlsuper;
//        hlo = hlapple;
    }

    static void m4(){
        hlq = h;
//        hlq = hl;
//        hlq = hlo;
//        hlq = hlextend;
//        hlq = hlsuper;
//        hlq = hlapple;
    }

    static void m5(){
        hlextend = h;
//        hlextend = hl;
//        hlextend = hlo;
//        hlextend = hlq;
//        hlextend = hlsuper;
//        hlextend = hlapple;
    }

    static void m6(){
        hlsuper = h;
//        hlsuper = hl;
//        hlsuper = hlo;
//        hlsuper = hlq;
//        hlsuper = hlextend;
//        hlsuper = hlapple;
    }

    static void m7(){
        hlapple = h;
//        hlapple = hl;
//        hlapple = hlo;
//        hlapple = hlq;
//        hlapple = hlextend;
//        hlapple = hlsuper;
    }
}
