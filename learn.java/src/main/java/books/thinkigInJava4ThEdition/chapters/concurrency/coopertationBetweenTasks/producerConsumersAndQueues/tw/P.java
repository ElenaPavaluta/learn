package books.thinkigInJava4ThEdition.chapters.concurrency.coopertationBetweenTasks.producerConsumersAndQueues.tw;

import java.util.concurrent.TimeUnit;

class P implements Runnable {

    private volatile int count;
    private R r;

    public P(R r) {
        this.r = r;
    }

    @Override
    public void run() {
        try {
            synchronized(this) {
                while(!Thread.interrupted()) {
                    M m = getM();
                    r.queue.put(m);
                    System.out.println("Produced: " + m);
                    TimeUnit.MILLISECONDS.sleep(500);
                }
            }
        } catch(InterruptedException e) {
            System.out.println("P interrupted");
        }
    }

    private synchronized M getM() {
        return new M(++count);
    }
}
