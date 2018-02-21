package books.thinkigInJava4ThEdition.chapters.concurrency.sharingResources.atomicClasses;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

class AtomicIntegerTest implements Runnable {
    private AtomicInteger i = new AtomicInteger(0);

    int getVal(){
        return  i.get();
    }

    void evenIncrement(){
        i.addAndGet(2);
    }

    @Override
    public void run() {
        while(true){
            evenIncrement();
        }
    }

    static void m(){
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.err.println("Aborting");
                System.exit(0);
            }
        },5000);
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicIntegerTest ait = new AtomicIntegerTest();
        exec.execute(ait);
        while(true){
            int val = ait.getVal();
            if(val %2 !=0){
                System.out.println(val);
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        m();
    }
}
