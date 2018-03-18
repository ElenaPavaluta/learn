package books.thinkigInJava4ThEdition.chapters.concurrency.newLibraryComponents.priorityBlockingQueue;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

class Demo {
    static void m(){
        Random rand = new Random(47);
        ExecutorService exec = Executors.newCachedThreadPool();

        PriorityBlockingQueue<Runnable> priorityBlockingQueue = new PriorityBlockingQueue<>();

        exec.execute(new PrioritizedTaskProducer(priorityBlockingQueue, exec));
        exec.execute(new PrioritizedTaskConsumer(priorityBlockingQueue));
    }

    public static void main(String[] args) {
        m();
    }
}
