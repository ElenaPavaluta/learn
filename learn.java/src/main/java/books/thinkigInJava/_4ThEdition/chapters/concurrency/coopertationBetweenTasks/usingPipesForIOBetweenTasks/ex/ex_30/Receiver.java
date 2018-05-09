package books.thinkigInJava._4ThEdition.chapters.concurrency.coopertationBetweenTasks.usingPipesForIOBetweenTasks.ex.ex_30;

import java.util.concurrent.BlockingQueue;

class Receiver implements Runnable {
    private BlockingQueue<Character> queue;

    public Receiver(BlockingQueue<Character> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while(true) {
                char c = queue.take();
                System.out.println(c);
            }
        } catch(InterruptedException e) {
            System.out.println("Receiver interrupted");
        }
    }
}
