package oc.p.chapters._7_Concurrency.usingConcurrentCollections.workingWithConcurrentClasses.set;

import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

class ConcurrentSkipListSet_ {
    /**
     * ->NavigableSet ->SortedSte ->Set
     */
    ConcurrentSkipListSet<Integer> set = new ConcurrentSkipListSet<>();

    ExecutorService exec = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws InterruptedException {
        ConcurrentSkipListSet_ c = new ConcurrentSkipListSet_();
        c.m();
        c.m2();
        c.m3();
        c.m4();
    }

    void m() throws InterruptedException {


        IntStream.range(0, 10)
                .forEach(i -> {
                    if (i % 2 == 0) {
                        exec.execute(() -> set.add(i));
                    } else {
                        exec.execute(() -> set.add(i));
                    }
                });
        TimeUnit.SECONDS.sleep(2);
        System.out.println(set);
    }

    void m2() {
        exec.submit(() -> System.out.println(set.first()));  //0
        exec.submit(() -> System.out.println(set.last()));  //9
    }

    void m3() {
        exec.submit(() -> System.out.println(set.ceiling(7)));  //7
        exec.submit(() -> System.out.println(set.floor(7)));  //7
        exec.submit(() -> System.out.println(set.higher(7)));  //8
        exec.submit(() -> System.out.println(set.lower(7)));   //6
    }

    void m4() throws InterruptedException {
        exec.submit(()-> set.forEach(i-> set.remove(i)));

        TimeUnit.SECONDS.sleep(3);
        exec.submit(()->System.out.println(set));
        exec.shutdownNow().forEach(System.out::println);
    }
}
