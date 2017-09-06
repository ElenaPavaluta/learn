package oc.p.chapters.c3_GenericsAndCollections.workingWithGenerics.genericInterfaces.interfaceMethods.defaulT;

interface Ship<T, U> {

    default T m(U u){return null;}

    default <T> T m2(U u){return null;}

    default <V> V m3(T t, U u){return null;}

    default <T, Q> T m4(U u, Q q){return null;}
}
