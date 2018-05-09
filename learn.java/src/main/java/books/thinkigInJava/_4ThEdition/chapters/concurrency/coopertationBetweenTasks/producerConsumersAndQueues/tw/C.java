package books.thinkigInJava._4ThEdition.chapters.concurrency.coopertationBetweenTasks.producerConsumersAndQueues.tw;

import java.util.concurrent.TimeUnit;

class C implements Runnable {
    private R r;

    public C(R r) {
        this.r = r;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                    M m = r.queue.take();
                    System.out.println("Consumed: " + m);
                    TimeUnit.MILLISECONDS.sleep(500);
            }
        } catch(InterruptedException e) {
            System.out.println("C interrupted");
        }
    }
}
