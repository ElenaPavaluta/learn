package oc.p.chapters._7_Concurrency.usingConcurrentCollections.workingWithConcurrentClasses.queue;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

class BDQ {

    static void m() throws InterruptedException {
        BlockingDeque<Integer> blockingDeque = new LinkedBlockingDeque<>();

        blockingDeque.offer(91);
        blockingDeque.offerFirst(5, 2, TimeUnit.MILLISECONDS);
        blockingDeque.offerLast(47, 100, TimeUnit.MILLISECONDS);
        blockingDeque.offer(3, 4, TimeUnit.MILLISECONDS);

        System.out.println(blockingDeque);  //5, 91, 47, 3

        System.out.println(blockingDeque.poll());  //5
        System.out.println(blockingDeque.poll(950, TimeUnit.MILLISECONDS));  //91
        System.out.println(blockingDeque.pollFirst(200, TimeUnit.MILLISECONDS));  //47
        System.out.println(blockingDeque.pollLast(1, TimeUnit.SECONDS));

        System.out.println(blockingDeque);
    }

    public static void main(String[] args) throws InterruptedException {
        m();
    }
}
