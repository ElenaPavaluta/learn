package books.thinkigInJava._4ThEdition.chapters.concurrency.newLibraryComponents.delayQueue;

import java.util.concurrent.DelayQueue;

class DelayedTaskConsumer implements Runnable{

    private DelayQueue<DelayedTask> queue;

    public DelayedTaskConsumer(DelayQueue<DelayedTask> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try{
            while(!Thread.interrupted()){
                queue.take().run();
            }
        }catch(InterruptedException e){
            //acceptable way to exit
        }
        System.out.println("Finished DelayedTaskConsumer");
    }
}
