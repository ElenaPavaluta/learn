package oc.p.chapters.c3_GenericsAndCollections.workingWithGenerics.genericInterfaces;

import oc.p.chapters.c3_GenericsAndCollections.workingWithGenerics.Elephant;
import oc.p.chapters.c3_GenericsAndCollections.workingWithGenerics.Robot;

class ShipableImpl2 implements Shipable<Robot>{

    @Override
    public void ship(Robot robot) {

    }

    @Override
    public <E> void ship2(E e) {

    }

    public static void main(String[] args) {
        ShipableImpl2 si = new ShipableImpl2 ();

        si.ship ( new Robot () );

        si.ship2 ( new Robot () );
        si.ship2 ( "a" );

        si.defaultShip ( new Robot () );
        si.<Robot>defaultShip( new Robot ()  );
//        si.<Elephant>defaultShip ( new Elephant () );  //compiler error

        si.<Elephant> defaultShip2 ( new Elephant () );
        si.defaultShip2 ( new Elephant () );
        si.defaultShip2 ( new Robot () );
        si.<Robot>defaultShip2 ( new Robot () );
//        si.<Robot>defaultShip2 ( new Elephant () );  //compiler error
    }
}
