package oc.p.chapters.c3_GenericsAndCollections.workingWithGenerics.genericInterfaces.interfaceMethods.defaulT;

import oc.p.chapters.c3_GenericsAndCollections.workingWithGenerics.Elephant;
import oc.p.chapters.c3_GenericsAndCollections.workingWithGenerics.Robot;

import java.time.LocalTime;

class ShipB implements Ship<Robot, Elephant>{

    private static Robot r;
    private static Elephant e;
    private static ShipB inst;
    
    static
    {
        inst = new ShipB ();
    }

    static void m(){
        r = inst.m ( e );
        r = inst.<Robot> m ( e );
        r = inst.<LocalTime> m(e);  //this is legal due to the fact that in the method definition
    }

    static void m2(){
        r = inst.m2 ( e );
        r = inst.<Robot> m2 ( e );
//        r = inst.<LocalTime> m2(e);  //compiler error
    }

    @Override
    public Robot m(Elephant elephant) {
        return null;
    }

    @Override
    public <T> T m2(Elephant elephant) {
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
