package oc.p.chapters._7_Concurrency.synchronizeDataAccess.tw._1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

class A {

    private int counter;

    static void m2() {
        A a = new A();
        ExecutorService exec = null;
        try {
            final int corePoolSize = Runtime.getRuntime().availableProcessors();
            exec = Executors.newScheduledThreadPool(corePoolSize);
            ExecutorService e = exec;
//            IntStream.range(0, corePoolSize).forEach(i->exec.submit(()->a.m()));  //exec must be final or effective final
            IntStream.range(0, corePoolSize)
                    .mapToObj(i->{
//                        Runnable r = ()->a.m();
                        Runnable r = ()-> a.m3();
                        return r;
                    })
                    .forEach(e::submit);

        } finally {
            if (exec != null) {
                exec.shutdown();
            }
        }
    }

    void m() {
        synchronized (this) {
                    System.out.println(Thread.currentThread().getId() + ": " + counter++);
                    try {
                        TimeUnit.MILLISECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
            }
        }
    }

    synchronized void m3() {
            System.out.println(Thread.currentThread().getId() + ": " + counter++);
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }

    public static void main(String[] args) {
        m2();
    }
}
