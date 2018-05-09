package books.thinkigInJava._4ThEdition.chapters.concurrency.newLibraryComponents.priorityBlockingQueue;

import java.util.concurrent.PriorityBlockingQueue;

class PrioritizedTaskConsumer implements Runnable {
    private PriorityBlockingQueue<Runnable> priorityBlockingQueue;

    public PrioritizedTaskConsumer(PriorityBlockingQueue<Runnable> priorityBlockingQueue) {
        this.priorityBlockingQueue = priorityBlockingQueue;
    }

    @Override
    public void run() {
        try{
            while(!Thread.interrupted()){
                priorityBlockingQueue.take().run();
            }
        }catch(InterruptedException e){
            System.out.println(this.getClass().getSimpleName() + " interrupted");
        }
        System.out.println("Finished " + this.getClass().getSimpleName());
    }
}
