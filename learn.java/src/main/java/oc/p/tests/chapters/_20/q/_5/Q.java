package oc.p.tests.chapters._20.q._5;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;

class Q {

    static void m(){
        List<Integer> original  = new ArrayList <>(Arrays.asList(1, 2, 3, 4 , 5));

        List<Integer> copy = new CopyOnWriteArrayList <>(original);
        for(Integer i: copy){
            copy.remove(i);
        }

        List<Integer> copy2 = Collections.synchronizedList(original);
        for(Integer i: copy2){
//            copy2.remove(i);
        }

        List<Integer> copy3 = new ArrayList <>(original);
        for(Integer i: copy3){
//            copy3.remove(i);
        }

        Queue<Integer> copy4 = new ConcurrentLinkedQueue <>(original);
        for(Integer i: copy4){
            copy4.remove();
        }
    }

    public static void main(String[] args) {
        m();
    }
}
