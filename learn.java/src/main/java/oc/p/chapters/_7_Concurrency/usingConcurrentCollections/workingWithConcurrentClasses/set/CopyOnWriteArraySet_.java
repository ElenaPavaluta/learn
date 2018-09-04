package oc.p.chapters._7_Concurrency.usingConcurrentCollections.workingWithConcurrentClasses.set;

import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

class CopyOnWriteArraySet_ {
    CopyOnWriteArraySet<Integer> copyOnWriteArraySet = new CopyOnWriteArraySet<>();

    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);

    void m() throws InterruptedException {

        IntStream.range(0, 10)
                .forEach(i -> {
                    if (i % 2 == 0) {
                        scheduledExecutorService.scheduleAtFixedRate(() -> copyOnWriteArraySet.add(i), 0, 50, TimeUnit.MILLISECONDS);
                    } else {
                        scheduledExecutorService.scheduleWithFixedDelay(() -> copyOnWriteArraySet.add(i), 0, 50, TimeUnit.MILLISECONDS);
                    }
                });
        TimeUnit.SECONDS.sleep(2);
        System.out.println("1: " + copyOnWriteArraySet);
    }

    void m2() throws InterruptedException {
        scheduledExecutorService.schedule(()->copyOnWriteArraySet.forEach(i->copyOnWriteArraySet.remove(i)),  1000, TimeUnit.MILLISECONDS);
        TimeUnit.SECONDS.sleep(2);
        System.out.println(scheduledExecutorService);
        System.out.println("2: " + copyOnWriteArraySet);
        scheduledExecutorService.shutdownNow();
    }
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArraySet_ c = new CopyOnWriteArraySet_();
        c.m();
        c.m2();
    }
}
