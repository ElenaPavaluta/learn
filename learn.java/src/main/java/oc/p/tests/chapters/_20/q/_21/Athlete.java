package oc.p.tests.chapters._20.q._21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Athlete {
    int stroke = 0;

    synchronized void swimming(){
        stroke++;
    }

    static void m(){
        ExecutorService exec = Executors.newFixedThreadPool(10);
        Athlete a = new Athlete();
        for(int i=0; i<1000; i++){
            exec.submit(()->a.swimming());
        }
        exec.shutdown();
        System.out.println(a.stroke);
    }

    public static void main(String[] args) {
        m();
    }
}
