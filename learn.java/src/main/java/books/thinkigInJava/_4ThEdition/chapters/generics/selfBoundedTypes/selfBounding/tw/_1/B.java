package books.thinkigInJava._4ThEdition.chapters.generics.selfBoundedTypes.selfBounding.tw._1;

class B extends SelfBounded<A>{

    public static void main(String[] args) {

        SelfBounded<A> sba = new SelfBounded<>();
        A a = new A();
        B b  =new B();

//        a.setT(b);
        b.setT(a);

        sba.setT(a);
//        sba.setT(b);

    }
}
