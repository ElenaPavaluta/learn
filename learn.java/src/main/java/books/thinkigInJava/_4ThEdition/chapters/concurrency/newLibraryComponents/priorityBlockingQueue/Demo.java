package books.thinkigInJava._4ThEdition.chapters.concurrency.newLibraryComponents.priorityBlockingQueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

class Demo {
    static void m(){
        ExecutorService exec = Executors.newCachedThreadPool();

        PriorityBlockingQueue<Runnable> priorityBlockingQueue = new PriorityBlockingQueue<>();

        exec.execute(new PrioritizedTaskProducer(priorityBlockingQueue, exec));
        exec.execute(new PrioritizedTaskConsumer(priorityBlockingQueue));
    }

    public static void main(String[] args) {
        m();
    }
}
