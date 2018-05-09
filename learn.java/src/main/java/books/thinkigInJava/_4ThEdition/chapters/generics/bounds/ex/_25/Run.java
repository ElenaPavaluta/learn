package books.thinkigInJava._4ThEdition.chapters.generics.bounds.ex._25;

class Run {
    static <T extends A> void m(T t){
        t.a();
    }

    static <T extends B> void m2(T t){
        t.b();
    }

    public static void main(String[] args) {
        C c = new C();
        m(c);
        m2(c);
    }
}
