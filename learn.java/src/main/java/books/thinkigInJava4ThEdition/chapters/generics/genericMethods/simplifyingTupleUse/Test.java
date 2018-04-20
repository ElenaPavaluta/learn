package books.thinkigInJava4ThEdition.chapters.generics.genericMethods.simplifyingTupleUse;

import oc.a.chapters.c5_class_design.implementingInterfaces.defaultInterfaceMethods.multipleInheritance.I;

class Test {

    static TwoTuple<String, Integer> f() {
        return Tuple.tuple("hi", 47);
    }

    static TwoTuple f2() {
        return Tuple.tuple("hi", 47);
    }


    static void t() {
        TwoTuple tt;

        tt = f();
        tt = f2();
    }

    static void t2() {
        TwoTuple<Object, Object> tt;

        /**
         * It's a compiler error because once a restriction
         * is present it must be obeyed.
         * TwoTuple == TwoTuple<?, ?>
         */
//        tt = f();
        tt = f2();
    }

    static void t3() {
        TwoTuple<?, ?> tt;

        tt = f();
        tt = f2();
    }

    static void t4(){
        TwoTuple<? extends Object, ? extends Object> tt;

        tt = f();
        tt = f2();
    }

    static void t5(){
        TwoTuple<? super String, ? super Integer> tt;

        tt = f();
        tt = f2();
    }
}
