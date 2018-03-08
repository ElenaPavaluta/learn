package books.thinkigInJava4ThEdition.chapters.concurrency.coopertationBetweenTasks.producersAndConsumers.tw.p5;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

class Run {

    C c = new C();

    public static void main(String[] args) throws InterruptedException {
        new Run().m();
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.exit(1);
            }
        }, 5000);
    }

    void m() throws InterruptedException {
        new Thread(new R()).start();

        while(true) {
            c.m2();
            TimeUnit.MILLISECONDS.sleep(500);
        }
    }

    class R implements Runnable {
        @Override
        public void run() {
            try {
                synchronized(c) {
                    while(!Thread.interrupted()) {
                        c.m();
                        TimeUnit.MILLISECONDS.sleep(300);
                    }
                }
            } catch(InterruptedException e) {
                System.out.println(" R interrupted");
            }
        }
    }
}
