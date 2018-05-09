package books.thinkigInJava._4ThEdition.chapters.concurrency.terminatingTasks.interruption.tw.p;

import java.util.concurrent.TimeUnit;

class R implements Runnable{
    int i;

    public R(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println("Thread: " + i);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch(InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
