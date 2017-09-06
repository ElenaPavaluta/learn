package oc.p.chapters.c3_GenericsAndCollections.workingWithGenerics.genericInterfaces.interfaceMethods.instance;

import java.time.LocalDate;

public class ShipC<X, Y> implements Ship<X, Y> {

    private static X x;
    private static Y y;

    private static ShipC<X, Y> inst;

    static {
        inst = new ShipC<> ( );
    }

    static void m() {
        x = inst.m ( y );
        x = inst.<X>m ( y );
        x = inst.<LocalDate>m ( y );  //because in the methods definition there's no definition for <> type the compiler just doesn't care
    }

    static void m2(){
        x = inst.m2 ( y );
        x = inst.<X> m2 ( y );
//        x = inst.<LocalDate> m2 ( y );  //compiler error: X type is expected in <>

    }

    @Override
    public X m(Y y) {
        return null;
    }

    @Override
    public <T> T m2(Y y) {
        return null;
    }

    @Override
    public <V> V m3(X x, Y y) {
        return null;
    }

    @Override
    public <T, Q> T m4(Y y, Q q) {
        return null;
    }
}
