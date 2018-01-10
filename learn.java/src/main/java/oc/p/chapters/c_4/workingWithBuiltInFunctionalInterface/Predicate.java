package oc.p.chapters.c_4.workingWithBuiltInFunctionalInterface;

@FunctionalInterface
interface Predicate<T> {

    boolean test(T t);
}

class P{
    static void m(){
        Predicate<P2> predicate = new Predicate<P2>() {
            @Override
            public boolean test(P2 p2) {
               return P2.m(p2);
            }
        };


        predicate.test(new P2());

        predicate = p -> P2.m(p);

        predicate = P2::m;  //static method reference
    }

    static void m2(){
        Predicate<P2> predicate = new Predicate<P2>() {
            @Override
            public boolean test(P2 p2) {
                return p2.m2();
            }
        };

        predicate = p -> p.m2();

        predicate = P2::m2;  //instance method reference on instance to be determined at runtime
    }

    static void m3(){
        P2 p2 = new P2();
        Predicate<Short> predicate = new Predicate<Short>() {
            @Override
            public boolean test(Short aShort) {
                return p2.m3(aShort);
            }
        };
        predicate.test((short)2);

        predicate = s -> p2.m3(s);

        predicate = p2::m3;
        predicate.test((short)23);
    }

    static void m4(){
        java.util.function.Predicate<String> egg = s ->s.contains("egg");
//        eggs = String::contains;  //

        java.util.function.Predicate<String> brown = s->s.contains("brown");

        java.util.function.Predicate<String> brownEggs = brown.and(egg);

        java.util.function.Predicate<String> notBrownEgg = egg.and(brown.negate());
    }
}


class P2{
    static boolean  m(P2 p){
        return  true;
    }

    boolean m2(){
        return true;
    }

    boolean m3(short s){
        return true;
    }
}
