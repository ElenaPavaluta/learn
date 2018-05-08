package books.thinkigInJava4ThEdition.chapters.generics.selfBoundedTypes.selfBounding.tw._1;

import java.util.Arrays;

class C extends SelfBounded<C> {

    public static void main(String[] args) {
        SelfBounded<A> sba = new SelfBounded<>();

        /**
         * Compiler error: B not within bounds. should extend SelfBounded<B>
         */
//        SelfBounded<B> sbb = new SelfBounded<B>();

        SelfBounded<C> sbc = new SelfBounded<>();

        A a = new A();
        B b = new B();
        C c = new C();

        sba.setT(a);
//        sba.setT(b);  //compiler error
//        sba.setT(c);  //compiler error

//        sbc.setT(a);  //compiler error
        sbc.setT(c);


        a.setT(a);
//        a.setT(b);
//        a.setT(c);

        b.setT(a);
//        b.setT(b);
//        b.setT(c);

//        c.setT(a);
//        c.setT(b);
        c.setT(c);

        System.out.println(Arrays.toString(sba.getClass().getGenericInterfaces()));
        System.out.println(Arrays.toString(sba.getClass().getInterfaces()));
        System.out.println(Arrays.toString(sba.getClass().getClasses()));
        System.out.println(sba.getClass().getSuperclass());
        System.out.println(sba.getClass().getGenericSuperclass());

    }
}
