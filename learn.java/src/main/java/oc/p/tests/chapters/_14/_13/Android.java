package oc.p.tests.chapters._14._13;

import java.util.function.Supplier;

class Android {
    void wakeUp(Supplier supplier){
        supplier.get();
    }

    public static void main(String[] args) {
        Android a = new Android();
//        a.wakeUp(()-> System.out.println("bla"));
    }
}
