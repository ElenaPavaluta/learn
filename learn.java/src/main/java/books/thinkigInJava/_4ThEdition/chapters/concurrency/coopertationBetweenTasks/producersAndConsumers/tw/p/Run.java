package books.thinkigInJava._4ThEdition.chapters.concurrency.coopertationBetweenTasks.producersAndConsumers.tw.p;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Run {
    static void m(){
        ExecutorService exec = Executors.newCachedThreadPool();
        C c = new C();

        exec.execute(new R(c));
        exec.execute(new R2(c));

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Drop the mike");
                System.exit(1);
            }
        }, 2_000);
    }

    public static void main(String[] args) {
        m();
    }
}
