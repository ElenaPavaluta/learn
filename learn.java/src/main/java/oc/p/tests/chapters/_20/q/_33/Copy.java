package oc.p.tests.chapters._20.q._33;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CopyOnWriteArrayList;

class Copy {
    static List<Integer> original  = new ArrayList <>(Arrays.asList(1, 2, 3));

    static void m(){
        List<Integer> list = new ArrayList <>(original);
        for (Integer i:list){
            list.add(1);
        }
    }

    static void m2(){
        List<Integer> list = new CopyOnWriteArrayList <>(original);
        for(Integer i: list){
            list.add(2);
        }
        System.out.println(list);
    }

    static void m3(){
        Deque<Integer> deque = new ConcurrentLinkedDeque <>(original);
        for (Integer i:deque){
            deque.push(3);
        }
        System.out.println(deque);
    }

    static void m4(){
        List<Integer> list = Collections.synchronizedList(original);
        for(Integer i: list){
            list.add(4);
        }
        System.out.println(list);
    }

    public static void main(String[] args) {
//        m();
//        m2();
//        m3();
        m4();
    }
}
