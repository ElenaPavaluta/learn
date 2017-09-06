package oc.p.chapters.c3_GenericsAndCollections.workingWithGenerics.genericInterfaces.interfaceMethods.instance;

import oc.p.chapters.c3_GenericsAndCollections.workingWithGenerics.Elephant;
import oc.p.chapters.c3_GenericsAndCollections.workingWithGenerics.Robot;

class ShipBB implements Ship<Robot, Elephant> {

    @Override
    public Robot m(Elephant elephant) {
        return null;
    }

    @Override
    public <Robot> Robot m2(Elephant elephant) {
        return null;
    }

    @Override
    public <V> V m3(Robot robot, Elephant elephant) {
        return null;
    }

    @Override
    public <T, Q> T m4(Elephant elephant, Q q) {
        return null;
    }
}
