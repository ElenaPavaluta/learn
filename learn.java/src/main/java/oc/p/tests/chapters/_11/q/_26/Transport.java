package oc.p.tests.chapters._11.q._26;

import oc.a.chapters._3_core_java_apis.javaArrays.usingAnArray.Array;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

class Transport {

    public static void main(String[] args) {
//        m();
//        m2();
//        m3();
//        m4();
//        m5();
//        m6();

        m7();
    }

    private static void m7() {
        List<Van> vans = new ArrayList<>();

//        System.out.println(vans instanceof ArrayList<Object>);
//        System.out.println(vans instanceof List<Object>);
    }

    private static void m6() {
        List<Van> vans = new ArrayList<>();

        System.out.println(vans instanceof ArrayList);  //true
        System.out.println(vans instanceof ArrayList<?>);  //true
        System.out.println(vans instanceof List);  //true
        System.out.println(vans instanceof List<?>);  //true

//        System.out.println(vans instanceof ArrayList<Vehicle>); //compiler error
//        System.out.println(vans instanceof ArrayList<Van>);

//        System.out.println(vans instanceof List<Van>);
//        System.out.println(vans instanceof List<Vehicle>);
    }

    private static void m5() {
        Vehicle v = new Van();
//        System.out.println(v instanceof LocalDateTime);  //compiler error
    }

    private static void m4() {
        Vehicle v  = new Bus();
        System.out.println(v instanceof InputStream);  //false: InputStream abstract class
    }

    private static void m3() {
        Vehicle v = new Bus();

        System.out.println(v instanceof Executor);  //false
    }

    private static void m2() {
        Van[] vans = new Van[0];

//        Van[] vans2 = new Bus[0];  //compiler error

//        Van[] vans3 = new Vehicle[0];  //compiler error

        System.out.println(vans instanceof Van[]);  //true
        System.out.println(vans instanceof Bus[]);  //true
        System.out.println(vans instanceof Vehicle[]);  //true
    }


    private static void m() {
        Bus bus = new Van();
        Van van = new Van();
        Van[] vans = new Van[0];

        boolean b = bus instanceof Vehicle;  //true
        boolean v = van instanceof Vehicle;  //true
        boolean a = vans instanceof Van[];  //true

        System.out.println(b);
        System.out.println(v);
        System.out.println(a);
    }

    static interface Vehicle {
    }

    static class Bus implements Vehicle {
    }

    static class Van extends Bus {
    }
}