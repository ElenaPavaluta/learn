package oc.p.tests.chapters._12.q._31.tw;

abstract class A {

    static void sm(){
        System.out.println("sm");
    }

    void m(){
        System.out.println("m");
    }
}

interface I{
    static void ism(){
        System.out.println("ism");
    }

    default void idm(){
        System.out.println("idm");
    }
}

class B  extends A implements I{
    public static void main(String[] args) {
        B b = new B();

        A.sm();
        b.sm();

        I.ism();
        /**
         * Compiler error
         * Since a static method cannot be overriden
         * what would happen when a class implement
         * 2 interfaces which have same signature for a static method
         */
//        b.ism();
    }
}
