package oc.p.chapters.c3_GenericsAndCollections.workingWithGenerics.interactingWithLegacyCode;

import java.util.ArrayList;
import java.util.List;

class LegacyCode {

    class A {
    }

    class B {

    }

    public static void main(String[] args) {
        List lst = new ArrayList ( );
        LegacyCode lc = new LegacyCode ( );
        lst.add ( lc.new A ( ) );
        lst.add ( lc.new A ( ) );
        lst.add ( lc.new B ( ) );

        m ( lst );
    }

    static void m(List<A> lst) {
        for (A a : lst) {  //ClassCastException
            System.out.println ( a );
        }
    }
}
