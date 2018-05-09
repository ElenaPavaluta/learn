package books.thinkigInJava._4ThEdition.chapters.generics.bounds.ex._25;

class C implements A, B {
    @Override
    public void a() {
        System.out.println("a");
    }

    @Override
    public void b() {
        System.out.println("b");
    }
}
