package oc.p.chapters.c3_GenericsAndCollections.workingWithGenerics.genericInterfaces;

import java.time.LocalTime;
import java.util.ArrayList;

class ShipableImpl implements Shipable{

    @Override
    public void ship(Object o) {

    }

    @Override
    public void ship2(Object o) {

    }

    public static void main(String[] args) {
        Shipable.staticShip ( "a" );
        Shipable.staticShip2 ( LocalTime.now () );

        ShipableImpl si = new ShipableImpl ();
//        si.staticShip("a");  //compiler error: the static methods aren't available for an impl

        si.ship ( null );
        si.ship2 ( "a" );
        si.defaultShip ( LocalTime.now () );
        si.defaultShip2 ( new ArrayList<ShipableImpl> (  ) );
    }
}
