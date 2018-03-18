package books.thinkigInJava4ThEdition.chapters.concurrency.newLibraryComponents.delayQueue;

import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class DelayedQueueDemo {

    static void m(){
        Random random = new Random(47);
        ExecutorService exec = Executors.newCachedThreadPool();

        DelayQueue<DelayedTask> queue = new DelayQueue<>();

        //Fill with tasks that have random delays
        for(int i=0; i<20; i++){
            queue.put(new DelayedTask(random.nextInt(5000)));
        }

        //Set the stopping point
        queue.add(new DelayedTask.EndSentinel(5000, exec));

        exec.execute(new DelayedTaskConsumer(queue));
    }

    public static void main(String[] args) {
        m();
    }
}
