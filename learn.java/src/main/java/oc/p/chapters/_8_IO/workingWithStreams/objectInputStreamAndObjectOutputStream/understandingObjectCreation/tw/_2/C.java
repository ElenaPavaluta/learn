package oc.p.chapters._8_IO.workingWithStreams.objectInputStreamAndObjectOutputStream.understandingObjectCreation.tw._2;


import java.io.Serializable;

class C extends B implements Serializable {
    static String varC = "C var";

    static {
        System.out.println("static initializer C");
    }

    {
        System.out.println("initalizer C");
    }

    C() {
        System.out.println("constructor C");
    }


    /**
     * Beware
     * Since this constructors are called from within this class,
     * the static initializer blocks are also called.
     * <p>
     * Same thing happens if empty psvm is called
     */
    static void m() {
//        new A();
//        new B();
//        new C();
    }

    public static void main(String[] args) {
        m();
    }
}
