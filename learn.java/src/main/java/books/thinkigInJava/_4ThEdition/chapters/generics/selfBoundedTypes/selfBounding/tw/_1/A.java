package books.thinkigInJava._4ThEdition.chapters.generics.selfBoundedTypes.selfBounding.tw._1;

class A extends SelfBounded<A> {

    public static void main(String[] args) {
        SelfBounded<A> sb = new SelfBounded<>();

//        SelfBounded<String> sbs = new SelfBounded<String>();  //compiler error
        A a = new A();
        a.setT(new A());

        sb.setT(a);

//        a.setT(sb);
    }
}

