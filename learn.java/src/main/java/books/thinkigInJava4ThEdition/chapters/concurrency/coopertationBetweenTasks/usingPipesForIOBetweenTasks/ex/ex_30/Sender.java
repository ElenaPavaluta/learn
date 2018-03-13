package books.thinkigInJava4ThEdition.chapters.concurrency.coopertationBetweenTasks.usingPipesForIOBetweenTasks.ex.ex_30;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

class Sender implements Runnable {
    private BlockingQueue<Character> queue;
    private Random rand = new Random(47);

    public Sender(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while(true) {
                synchronized(this) {
                    for(char c = 'A'; c < 'z'; c++) {
                        queue.put(c);
                    }
                    System.out.println("Thread: " +Thread.currentThread().getId());
                    TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
                }
            }
        } catch(InterruptedException e) {
            System.out.println("Sender interrupted");
        }
    }
}
