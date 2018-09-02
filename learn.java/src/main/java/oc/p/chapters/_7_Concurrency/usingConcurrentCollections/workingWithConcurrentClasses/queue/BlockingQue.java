package oc.p.chapters._7_Concurrency.usingConcurrentCollections.workingWithConcurrentClasses.queue;

import java.util.concurrent.*;

class BlockingQue {

    BlockingQueue<Integer> bq = new LinkedBlockingQueue<>();
    Runnable r = () -> {
        try {
            System.out.println("offer: " + bq.offer(1, 1000, TimeUnit.MILLISECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    };

    Runnable r2 = () -> {
        try {
            System.out.println("poll: "+ bq.poll(250, TimeUnit.MILLISECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    };

    void m() throws InterruptedException {
        BlockingQue bq = new BlockingQue();
        ScheduledExecutorService exec = Executors.newScheduledThreadPool(2);
        exec.scheduleAtFixedRate(r, 0, 1000, TimeUnit.MILLISECONDS);
        exec.scheduleAtFixedRate(r2, 0, 250, TimeUnit.MILLISECONDS);
        TimeUnit.SECONDS.sleep(7);
        exec.shutdownNow();
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQue bq = new BlockingQue();
        bq.m();
    }
}
