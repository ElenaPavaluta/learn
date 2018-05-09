package books.thinkigInJava._4ThEdition.chapters.concurrency.newLibraryComponents.priorityBlockingQueue.tw;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

class Demo {

    static void m() {
        PriorityBlockingQueue<Task> queue = new PriorityBlockingQueue<>();
        ExecutorService exec = Executors.newCachedThreadPool();

        Producer p = new Producer(queue, exec);
        Consumer c = new Consumer(queue, exec);

        exec.execute(p);
        exec.execute(c);
    }

    public static void main(String[] args) {
        m();
    }
}
