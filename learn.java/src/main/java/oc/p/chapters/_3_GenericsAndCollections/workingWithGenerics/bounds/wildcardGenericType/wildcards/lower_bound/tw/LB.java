package oc.p.chapters._3_GenericsAndCollections.workingWithGenerics.bounds.wildcardGenericType.wildcards.lower_bound.tw;

import java.util.ArrayList;
import java.util.List;

class LB {
    class A{}
    class B extends A{}

    Object o = new Object();
    A a = new A();
    B b  = new B();

    List<Object> lo;
    List<A> la;
    List<B> lb;

    List<? super A> lsa;
    List<? super B> lsb;

    {
        lo = new ArrayList<>();
        lo.add(o);
        lo.add(a);
        lo.add(b);

        la = new ArrayList<>();
//        la.add(o);  //compiler error
        la.add(a);
        la.add(b);

        lb = new ArrayList<>();
//        lb.add(o);  //compiler error
//        lb.add(a);  //compiler error
        lb.add(b);
    }

    {
        lsa = new ArrayList<>();  //new ArrayList<A>()
//        lsa.add(o);  //compiler error
        lsa.add(a);
        lsa.add(b);

        lsa = new ArrayList<Object>();
//        lsa.add(o);
        lsa.add(a);
        lsa.add(b);

//        lsa = new ArrayList<B>();  //compiler error

        lsa = lo;
        lsa = la;
//        lsa = lb;  //compiler error
    }

    {
        lsb = new ArrayList<>();
//        lsb.add(o);  //compiler error
//        lsb.add(a);
        lsb.add(b);

        lsb = new ArrayList<Object>();
        lsb = new ArrayList<A>();
        lsb = new ArrayList<B>();

        lsb = lo;
        lsb = la;
        lsb = lb;
    }
}
