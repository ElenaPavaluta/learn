package books.thinkigInJava._4ThEdition.chapters.concurrency.coopertationBetweenTasks.producersAndConsumers.ex.ex_24;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

class Run {

    static void m() throws InterruptedException {
        Buffer b = new Buffer();
        ExecutorService exec = Executors.newCachedThreadPool();

        IntStream.range(0, 8)
                 .forEach(i -> {
                     exec.execute(new C(b));
                     exec.execute(new P(b));
                 });

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                exec.shutdownNow();
                System.exit(0);
            }
        }, 4000);

    }

    public static void main(String[] args) throws InterruptedException {
        m();
    }
}
