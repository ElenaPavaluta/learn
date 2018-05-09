package books.thinkigInJava._4ThEdition.chapters.concurrency.newLibraryComponents.countDownLatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

//Performs some portion of a task
class TaskPortion implements Runnable{
    private static int counter = 0;
    private final int id = counter++;
    private static final Random rand = new Random(47);

    private final CountDownLatch latch;

    public TaskPortion(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try{
            doWork();
            latch.countDown();
        }catch(InterruptedException e){
           //Acceptable way to exit
        }
    }

    void doWork() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(rand.nextInt(2000));
        System.out.println(this + " completed");
    }

    @Override
    public String toString() {
        return String.format("%1$-3d ", id);
    }
}
