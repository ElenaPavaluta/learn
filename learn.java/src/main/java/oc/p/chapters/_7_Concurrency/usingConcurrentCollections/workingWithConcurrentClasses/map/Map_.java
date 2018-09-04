package oc.p.chapters._7_Concurrency.usingConcurrentCollections.workingWithConcurrentClasses.map;

import javafx.concurrent.ScheduledService;

import java.util.NavigableMap;
import java.util.Random;
import java.util.SortedMap;
import java.util.concurrent.*;
import java.util.stream.IntStream;

class Map_ {

    /**
     * -> ConcurrentMap -> Map
     */
    ConcurrentHashMap<Integer, Integer> concurrentHashMap;

    /**
     * ConcurrentNavigableMap -> ConcurrentMap & NavigableMap -> SortedMap
     */
    ConcurrentSkipListMap<Integer, Integer> conurentSkipLisMap = new ConcurrentSkipListMap<>();


    SortedMap<Integer, Integer> sortedMap;

    NavigableMap<Integer, Integer> navigableMap;

    {
        Random r = new Random(47);
        IntStream.range(0, 10)
                .forEach(i -> {
                    new Thread(() -> {
                        try {
                            TimeUnit.MILLISECONDS.sleep(r.nextInt(50));
                             conurentSkipLisMap.putIfAbsent(i, i);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }).start();
                });
    }

    void print(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        conurentSkipLisMap.forEach((k, v)-> System.out.println(k + " -> " + v));
    }

    void sortedMap(){
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        sortedMap = conurentSkipLisMap;

        System.out.println(sortedMap.firstKey());
        System.out.println(sortedMap.lastKey());
        scheduledExecutorService.shutdownNow();
    }

    void navigableMap(){
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        navigableMap = conurentSkipLisMap;

        //the methods are coming from SortedMap
        System.out.println(navigableMap.firstKey());
        System.out.println(navigableMap.lastKey());

        System.out.println(navigableMap.firstEntry());  //0-0
        System.out.println(navigableMap.lastEntry());  //9-9

        System.out.println(navigableMap.lowerKey(7));  //6
        System.out.println(navigableMap.lowerEntry(7));  //6

        System.out.println(navigableMap.floorKey(7));  //7
        System.out.println(navigableMap.floorEntry(7));

        System.out.println(navigableMap.ceilingKey(7));  //7
        System.out.println(navigableMap.ceilingEntry(7));

        System.out.println(navigableMap.higherKey(7));  //8
        System.out.println(navigableMap.higherEntry(7));

        scheduledExecutorService.shutdownNow();
    }

    public static void main(String[] args) throws InterruptedException {
        Map_ m = new Map_();
        TimeUnit.SECONDS.sleep(2);
//        m.print();
//        m.sortedMap();
        m.navigableMap();
    }
}
