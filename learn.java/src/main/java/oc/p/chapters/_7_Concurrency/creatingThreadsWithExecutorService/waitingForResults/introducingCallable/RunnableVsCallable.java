package oc.p.chapters._7_Concurrency.creatingThreadsWithExecutorService.waitingForResults.introducingCallable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @FunctionalInterface
 * public interface Runnable {
 *     void run();
 * }
 *
 * @FunctionalInterface
 * public interface Callable<V> {
 * V call() throws Exception;
 * }
 */
class RunnableVsCallable {

    static void m(){
        Runnable r = ()->{
            throw new RuntimeException();
        };

        Callable<?> c = ()->{
            throw new RuntimeException();
        };
    }

    static void m2(){
        Runnable r = ()->{
//            throw new Exception();  //compiler error
        };

        Callable<?> c = ()->{
          throw new Exception();
        };
    }

    static void m3(){
//        Runnable r = ()->3;  //compiler errors

        Callable<Integer> c = ()->3;
    }

    static void m4(){
        Runnable r = ()-> {
            System.out.println(3);
//            return 3;
            return;
        };

        Callable<Integer> c = ()-> {
            System.out.println(3);
            return 3;
        };

        r.run();

        try {
            c.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void m5(){
        ExecutorService exec = null;

        exec.submit(()->{
            TimeUnit.MILLISECONDS.sleep(100);
            return null;
        });

        exec.submit(()->{
            /**
             * Doesn't compile since the run method of the
             */
//            TimeUnit.MILLISECONDS.sleep(100);
        });
    }

}
