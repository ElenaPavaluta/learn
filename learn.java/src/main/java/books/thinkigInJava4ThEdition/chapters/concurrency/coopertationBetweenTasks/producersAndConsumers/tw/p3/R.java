package books.thinkigInJava4ThEdition.chapters.concurrency.coopertationBetweenTasks.producersAndConsumers.tw.p3;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class R {

    C c = new C();

    Runnable r2 = () -> c.m007();
    Runnable r3 = () ->c.justM();

    void m(){
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(r2);
        exec.execute(r3);
    }

    public static void main(String[] args) {
        new R().m();
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.exit(1);
            }
        }, 1_000);
    }
}
