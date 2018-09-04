package oc.p.chapters._7_Concurrency.usingConcurrentCollections.obtainigSynchronizedCollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class SC {

    static void m() {
        List<Integer> lst = Collections.synchronizedList(new ArrayList<>(Arrays.asList(4, 3, 52)));

        synchronized (lst){
            for(int i: lst){
                System.out.println(i);
//                lst.add(9);  //ConcurrentModificationException
            }
        }
    }

    public static void main(String[] args) {
        m();
    }
}
