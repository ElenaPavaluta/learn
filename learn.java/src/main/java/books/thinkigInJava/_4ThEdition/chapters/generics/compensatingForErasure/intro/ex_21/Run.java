package books.thinkigInJava._4ThEdition.chapters.generics.compensatingForErasure.intro.ex_21;

class Run {
    static ClassTypeCapture<String> ctc = new ClassTypeCapture<>(String.class);

    static {
        ctc.addType("a", A.class);
        ctc.addType("b", B.class);
        ctc.addType("c", C.class);
        ctc.addType("d", D.class);
        ctc.addType("o", Object.class);
    }


    static void m(String s) {
        Object o = ctc.createNew(s);
        instanceOf(o);
        System.out.println();
//        isInstance(o);
    }

    static void instanceOf(Object o) {
        System.out.println(o instanceof A);
        System.out.println(o instanceof B);
        System.out.println(o instanceof C);
        System.out.println(o instanceof D);
        System.out.println(o instanceof Object);
    }

    static void isInstance(Object o) {
        System.out.println(o.getClass().isInstance(new A()));
        System.out.println(o.getClass().isInstance(new B()));
        System.out.println(o.getClass().isInstance(new C()));
        System.out.println(o.getClass().isInstance(new D()));
        System.out.println(o.getClass().isInstance(new Object()));
    }


    public static void main(String[] args) {
//        createAndPopulate("a"); //t, f, f, f, t ; t, f, f, f, f

        m("n");  //RE at newInstance()
    }
}
