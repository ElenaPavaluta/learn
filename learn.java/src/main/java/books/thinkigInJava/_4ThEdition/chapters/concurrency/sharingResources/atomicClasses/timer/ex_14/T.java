package books.thinkigInJava._4ThEdition.chapters.concurrency.sharingResources.atomicClasses.timer.ex_14;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.LongStream;

class T {
    TimerTask tt = new TimerTask() {
        @Override
        public void run() {
            System.out.println("tt abort");
        }
    };

    Runnable r = () -> System.out.println("r");

    ThreadFactory tf = new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {

            Thread t = new Thread(r);
            t.setDaemon(true);
            t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                @Override
                public void uncaughtException(Thread t, Throwable e) {
                    System.err.println("err");
                }
            });
            return t;
        }
    };

    ExecutorService exec = Executors.newCachedThreadPool(tf);

    public static void main(String[] args) {
        new T().m();
    }

    void m() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(" 2 s  timer task");
            }
        },2000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("1 s timer task");
            }
        }, 1000);

        timer.schedule(tt, 3000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("exit now");
                System.exit(0);
            }
        }, 4000);

        LongStream.range(1, 10)
                  .forEach(l -> {
                      exec.execute(r);
                  });
        exec.shutdown();
    }
}
