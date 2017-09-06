package oc.p.chapters.c3_GenericsAndCollections.workingWithGenerics.genericInterfaces.interfaceMethods.instance;

interface Ship<T, U> {

    T m(U u);

    <T> T m2(U u);

    <V> V m3(T t, U u);

    public abstract <T, Q> T m4(U u, Q q);
}
