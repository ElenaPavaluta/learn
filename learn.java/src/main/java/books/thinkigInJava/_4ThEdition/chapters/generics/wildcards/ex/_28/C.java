package books.thinkigInJava._4ThEdition.chapters.generics.wildcards.ex._28;

class C<T> {

    static C<Animal> c = new C<>();

    static void m3() {
        Generic.Impl<Cat> g = new Generic.Impl<>();
        c.m(g, new Cat());

        c.m(g, new YellowCat());

        /**
         * The reference type is Generic.Impl<Cat>
         *     Same as
         *   List<Cat> = List<YellowCat>
         */
//        g = new Generic.Impl<YellowCat>(); compiler error
//        List<Cat> l =  new ArrayList<YellowCat>();

        Generic.Impl<Animal> g2 = new Generic.Impl<>();
        c.m(g2, new WildAnimal());
        c.m(g2, new YellowCat());
        c.m(g2, new Dog());
    }

    static void m4(){
        Generic2.Impl<Pet> g = new Generic2.Impl<>();
        Pet p = c.m2(g);
    }

    public static void main(String[] args) {
//        m3();
        m4();
    }

    <X extends T> void m(Generic<X> g, X x) {
        g.m(x);
    }

    <X extends T> X m2(Generic2<X> g) {
        return g.m();
    }
}
