package books.thinkigInJava._4ThEdition.chapters.concurrency.baiscThreading.sleeping;

import books.thinkigInJava._4ThEdition.chapters.concurrency.baiscThreading.definingTasks.LiftOff;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * The call to sleep() can throw an InterruptedException,
 * and you can see that this is caught in run( ).
 *
 * Because exceptions won’t propagate across threads back to main(),
 * you must locally handle any exceptions that arise within a task.
 *
 */
class SleepingTask extends LiftOff {

    @Override
    public void run() {
        try{
       while(countDown-- >0){
           System.out.print(status());
           //Thread.sleep(100) //Old-style

           //Java SE5/6 style:
           TimeUnit.MILLISECONDS.sleep(5000);
       }

    }catch(InterruptedException e){
            System.out.println("Interrupted");}
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        for(int i = 0; i<5; i++){
            service.execute(new SleepingTask());
        }
        service.shutdown();
    }
}
