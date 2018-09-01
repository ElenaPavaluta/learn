package oc.p.chapters._7_Concurrency.usingConcurrentCollections.understandingMemoryConsistencyErrors;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

class Err {


    {
        Map<Integer, Integer> map;
        map = new HashMap<>();
        map = new TreeMap<>();  //implements NavigableMap ->Sortedmap
        map = new LinkedHashMap<>();
        map = new Hashtable<>();  //doesn't accept null keys or values
    }

    public static void main(String[] args) {
        Err err = new Err();

//        err.problem();
        err.solve();
    }


    void problem() {
        m(new HashMap<>());  //RE: java.util.ConcurrentModificationException
    }

    void solve() {
        m(new ConcurrentHashMap<>());
    }

    private void m(Map<Integer, Integer> map) {
        map.putIfAbsent(1, 1);
        map.putIfAbsent(2, 2);

        map.forEach((k, v) -> {
            map.remove(k);
        });

        System.out.println(map.size());
    }
}
