package books.thinkigInJava4ThEdition.chapters.concurrency.coopertationBetweenTasks.producersAndConsumers.tw.p4;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Run {

    C c = new C();
    Runnable r = () ->c.m();
    Runnable r2 = () ->c.m2();
    Runnable r3 = () ->c.m3();

    void m(){
        ExecutorService exec  = Executors.newCachedThreadPool();
        exec.execute(r);
        exec.execute(r2);
        exec.execute(r3);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.exit(1);
            }
        }, 4000);
    }

    public static void main(String[] args) {
        new Run().m();
    }
}
