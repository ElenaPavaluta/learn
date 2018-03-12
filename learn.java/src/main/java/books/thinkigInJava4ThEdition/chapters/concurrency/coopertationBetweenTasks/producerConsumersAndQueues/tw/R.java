package books.thinkigInJava4ThEdition.chapters.concurrency.coopertationBetweenTasks.producerConsumersAndQueues.tw;

import java.util.concurrent.*;
import java.util.stream.IntStream;

class R {

    M m;

    /**
     * A blocking queue in which each insert operation must wait for a
     * corresponding remove operation by another thread, and vice v ersa.
     * A synchronous queue does not have any internal capacity,
     * not even a capacity of one
     */
    BlockingQueue<M> queue = new SynchronousQueue<>();

    ExecutorService exec = Executors.newCachedThreadPool();

    void m() throws InterruptedException {
        IntStream.range(0, 10)
                 .forEach(i -> {
                     exec.execute(new P(this));
                     exec.execute(new C(this));
                 });

        TimeUnit.SECONDS.sleep(2);
        exec.shutdownNow();
    }

    public static void main(String[] args) throws InterruptedException {
        new R().m();
    }
}
