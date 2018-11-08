package oc.p.chapters._7_Concurrency.usingConcurrentCollections.ocpCollections;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

class List_ {

    List <Ocp> lst;

    {
        lst = new ArrayList <>();
        lst = new LinkedList <>();
        lst = new Vector <>();
        lst = new Stack <>();

        lst = new CopyOnWriteArrayList <>();
        lst = Collections.synchronizedList(lst);
    }

    {
        Vector <Ocp> vector = new Stack <>();
    }
}
