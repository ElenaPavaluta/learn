package books.thinkigInJava._4ThEdition.chapters.concurrency.coopertationBetweenTasks.producersAndConsumers.tw.p;

import java.util.concurrent.TimeUnit;

class R2 implements Runnable {
    private C c;

    public R2(C c) {
        this.c = c;
    }

    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(100);
            System.out.println("increment i");
            c.n++;
        } catch(InterruptedException e) {
            System.out.println("R2 interrupted");
        }
    }
}
