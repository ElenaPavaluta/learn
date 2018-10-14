package oc.p.tests.chapters._13.q._20;

import java.util.*;

class C {
    Comparator <Integer> comp = (x, y) -> x - y;
    Comparator <Integer> comp2 = (x, y) -> y - x;

    List<Integer> lst = Arrays.asList(3, 9, 1, 0, 10, 17, 7, 7);

    void m(){
        Collections.sort(lst, comp);
        System.out.println(lst);
        Collections.sort(lst, comp2);
        System.out.println(lst);
    }

    public static void main(String[] args) {
        C c = new C();
        c.m();
    }
}
