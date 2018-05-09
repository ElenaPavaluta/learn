package books.thinkigInJava._4ThEdition.chapters.concurrency.baiscThreading.priority.ex9;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Run {

    static void tc() {
        double d = 0;
        for(int i = 1; i < 100_000_000; i++) {
            d += (Math.PI + Math.E) / (double) i;
            if(i % 1_000 == 0) {
                Thread.yield();
            }
        }
    }

    class R implements Runnable{
        int i;

        R(int i){
            this.i = i;
        }

        @Override
        public void run() {
            Thread.currentThread().setName("T: " + i);
            tc();
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        m();
    }

    private static void m() {
        ExecutorService eMax = Executors.newCachedThreadPool(new TFmax());
        ExecutorService eMin= Executors.newCachedThreadPool(new TFmin());
        for(int i = 0; i<10; i++){
            eMin.execute(new Run(). new R(i));
            eMax.execute(new Run(). new R(++i));
        }
        eMin.shutdown();
        eMax.shutdown();
    }
}
