package oc.p.chapters._7_Concurrency.usingConcurrentCollections.workingWithConcurrentClasses.list;

import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

class Lst {

    /**
     * ->List
     */
    CopyOnWriteArrayList<Integer> copyOnWriteArrayList;

    void m(){
        copyOnWriteArrayList = new CopyOnWriteArrayList<>(Arrays.asList(1, 2, 3));

        for(int i: copyOnWriteArrayList){
            System.out.print(i + " ");
            copyOnWriteArrayList.add(9);
        }
        System.out.println();
        System.out.println("size: " + copyOnWriteArrayList.size());
        System.out.println(copyOnWriteArrayList);
    }

    public static void main(String[] args) {
        Lst l = new Lst();
        l.m();
    }


}
