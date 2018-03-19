package books.thinkigInJava4ThEdition.chapters.concurrency.newLibraryComponents.priorityBlockingQueue.tw;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;

class Consumer implements Runnable {

    private BlockingQueue<Task> queue;
    private ExecutorService exec;

    public Consumer(BlockingQueue<Task> queue, ExecutorService exec) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                queue.take().run();
            }
        } catch(InterruptedException e) {
            System.out.println("consumer interrupted");
        }
    }
}
