package oc.p.chapters.c3_GenericsAndCollections.workingWithGenerics.genericInterfaces;

interface Shipable<T> {

    void ship(T t);

    <E> void ship2(E e);

    static <E> void staticShip(E e){
        System.out.println ( "staticShip" );
    }

    default void defaultShip(T t){
        System.out.println ( "default" );
    }
}
