package books.thinkigInJava4ThEdition.chapters.concurrency.coopertationBetweenTasks.blockingQueuesOfToast;

import java.util.Random;
import java.util.concurrent.TimeUnit;

class Toaster implements Runnable {
    private ToastQueue queue;
    private int count = 0;
    private Random rand = new Random(47);

    public Toaster(ToastQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try{
            while(!Thread.interrupted()){
                TimeUnit.MILLISECONDS.sleep(100 + rand.nextInt(500));
                Toast t = new Toast(count++);
                System.out.println(t);
                queue.put(t);
            }
        }catch(InterruptedException e){
            System.out.println("Toaster interrupted");
        }
        System.out.println("Toaster off");
    }
}
