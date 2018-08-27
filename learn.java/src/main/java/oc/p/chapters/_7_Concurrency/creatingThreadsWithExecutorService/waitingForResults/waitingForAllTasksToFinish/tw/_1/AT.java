package oc.p.chapters._7_Concurrency.creatingThreadsWithExecutorService.waitingForResults.waitingForAllTasksToFinish.tw._1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
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
 */
class AT {

    static List<Callable<Integer>> lst;
    static ExecutorService exec;

    static {
        Random rand = new Random(47);
        lst = IntStream.range(0, 10)
                .mapToObj(i -> {
                    Callable<Integer> c = () -> {
                        TimeUnit.MILLISECONDS.sleep(rand.nextInt(200));
                        return i;
                    };
                    return c;
                })
                .collect(toList());
    }

    static void m(){
        List<Future<Integer>> lf = new ArrayList<>();
        try {
            exec = Executors.newCachedThreadPool();
            lst.forEach(i -> {
                lf.add(exec.submit(i));
            });
        }finally {
            if(exec !=null){
                exec.shutdown();
                System.out.println("isShutdown: " +exec.isShutdown());  //true
                System.out.println("isTerminated:" + exec.isTerminated());  //false

                try {
                    System.out.println("await termination: " + exec.awaitTermination(105, TimeUnit.MILLISECONDS));
                    System.out.println("isTerminated: " + exec.isTerminated());
                    lf.forEach(f -> {
                        try {
                            System.out.println(f.get());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        m();
    }
}
