package books.thinkigInJava._4ThEdition.chapters.generics.selfBoundedTypes.ex._34;

abstract class SelfBounded<T extends SelfBounded<T>> {

    abstract T m(T t);

    abstract <T extends SelfBounded<T>> T m2(T t);
}

class Impl extends SelfBounded<Impl>{
    @Override
    Impl m(Impl impl) {
        return impl;
    }

    @Override
    <T extends SelfBounded<T>> T m2(T t) {
        return t;
    }
}

class Impl2 extends Impl{

}

class X extends SelfBounded<X>{
    @Override
    X m(X x) {
        return null;
    }

    @Override
    <T extends SelfBounded<T>> T m2(T t) {
        return null;
    }
}

class Run{
    public static void main(String[] args) {

        Impl  i = new Impl();
        Impl2 i2 = new Impl2();

        i.m(i);
        i.m2(i);

        i.m(i2);
        i.m2(i2);


        i2.m(i);
        i2.m2(i);

        i2.m(i2);
        i2.m2(i2);

        X x = new X();

//        i.m(x);  //compiler error
        i.m2(x);  //ok

//        i2.m(x);  //compiler error
        i2.m2(x);

        x.m2(i);
        x.m2(i2);
    }
}
