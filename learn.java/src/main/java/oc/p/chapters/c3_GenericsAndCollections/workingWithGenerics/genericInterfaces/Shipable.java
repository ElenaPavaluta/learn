package oc.p.chapters.c3_GenericsAndCollections.workingWithGenerics.genericInterfaces;

interface Shipable<T> {

    void ship(T t);

    <E> void ship2(E e);

    static <E> void staticShip(E e){
        System.out.println ( "staticShip" );
    }

    static <T> void staticShip2(T t){};


    default void defaultShip(T t){
        System.out.println ( "default" );
    }

    default <E> void defaultShip2(E e){}
}
