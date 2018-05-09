package books.thinkigInJava._4ThEdition.chapters.concurrency.sharingResources.synchronizingOnOtherObjects.tw.sync;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

class Run {
    static void abort() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("drop the mike");
                System.exit(0);
            }
        }, 3000);
    }

    static void m(Runnable r) {
        ExecutorService exec = Executors.newCachedThreadPool();
        IntStream.range(0, 10)
                 .forEach(i -> exec.execute(r));
        exec.shutdown();
    }



    public static void main(String[] args) {
        abort();
        m(new T());
//        m(new T2());
//        m(new T3());
//        m(new T4());
    }
}
