package books.thinkigInJava._4ThEdition.chapters.generics.compensatingForErasure.creatingInstancesOfTypes.ex._22;

class Run {

    static void c(){
        C c = Factory.create(C.class, String.class);
        System.out.println(c.getClass().getSimpleName());
    }

    static void a(){
        A a = Factory.create(A.class, A.A2.class, A.A3.class, A.A4.class);
        System.out.println(a.getClass().getSimpleName());
    }

    static void d(){
        D d = Factory.create(D.class, E.class);
        System.out.println(d.getClass().getSimpleName());
    }

    public static void main(String[] args) {
//        c();
//        a();
        d();

    }
}
