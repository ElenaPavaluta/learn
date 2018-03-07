package books.thinkigInJava4ThEdition.chapters.concurrency.coopertationBetweenTasks.producersAndConsumers.ex.ex_24;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

class Buffer {

    int index = 0;
    int max = 5;
    int[] buffer = new int[max];

    static void m() {
        Buffer b = new Buffer();
        ExecutorService exec = Executors.newCachedThreadPool();
        IntStream.range(0, 5).forEach(i -> {
            exec.execute(new C(b));
            exec.execute(new P(b));
        });
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Drop de mike");
                exec.shutdownNow();
                System.exit(1);
            }
        }, 5000);
    }

    public static void main(String[] args) {
        m();
    }

}
