package oc.p.chapters.c3_GenericsAndCollections.workingWithGenerics.genericInterfaces;

import oc.p.chapters.c3_GenericsAndCollections.workingWithGenerics.Elephant;
import oc.p.chapters.c3_GenericsAndCollections.workingWithGenerics.Robot;

import java.time.LocalDateTime;

class ShipableImpl2 implements Shipable<Robot>{

    @Override
    public void ship(Robot robot) {

    }

}
