package oc.p.chapters.c3_GenericsAndCollections.workingWithGenerics.genericInterfaces;

class ShipableImpl3<U> implements  Shipable<U>{

    @Override
    public void ship(U u) {

    }

    @Override
    public <E> void ship2(E e) {

    }

    public static void main(String[] args) {

    }
}
