package oc.p.chapters._7_Concurrency.creatingThreadsWithExecutorService.waitingForResults.waitingForAllTasksToFinish.tw._2;

import sun.rmi.runtime.RuntimeUtil;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * Blocks until
 *
 * all tasks have completed execution after a shutdown request,
 * or the timeout occurs,
 * or the current thread is interrupted,
 *
 * whichever happens first.
 *
 * boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException;
 *
 *
 * Returns
 * true if this executor terminated and
 * false if the timeout elapsed before termination
 */
class AT {
    static Random random = new Random(47);
    static Runnable r = () -> {
        try {
            TimeUnit.MILLISECONDS.sleep(random.nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    };
    static List<Runnable> lr;
    static {
        lr = IntStream.range(0, 10)
                .mapToObj(i->r)
                .collect(toList());
    }

    static void m(int timeout) throws InterruptedException {
        ExecutorService exec = null;
        try {
            exec = Executors.newCachedThreadPool();
            lr.forEach(exec::submit);
        }finally {
            if(exec!=null){
                exec.shutdown();
                System.out.println(exec.awaitTermination(timeout, TimeUnit.MILLISECONDS));
                System.out.println("after awaitTermination");
                System.out.println(exec.isTerminated());
            }
        }
    }

    static void m2(){
        Runnable r = () -> {
            try {
                m(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        new Thread(r).start();
    }



    public static void main(String[] args) throws InterruptedException {
//        m(300);
//        m(10);
        m2();
    }

}
