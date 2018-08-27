package oc.p.chapters._7_Concurrency.creatingThreadsWithExecutorService.waitingForResults.waitingForAllTasksToFinish;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
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
class AwaitTermination {
    static List<Runnable> lst;

    static {
        Random rand = new Random(47);
        lst = IntStream.range(0, 20).mapToObj(
                i -> {
                    Runnable r = () -> {
                        try {
                            TimeUnit.MILLISECONDS.sleep(rand.nextInt(100));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    };
                    return r;
                }).collect(toList());
    }

    static void m() throws InterruptedException {
        ExecutorService exec = null;
        try {
            exec = Executors.newCachedThreadPool();
            lst.forEach(exec::submit);
        } finally {
            if (exec != null) {
                exec.shutdown();
            }
        }

        if (exec != null) {
            exec.awaitTermination(100, TimeUnit.MILLISECONDS);
            if (exec.isTerminated()) {
                System.out.println("All tasks finished");
            } else {
                System.out.println("At least one task is still running");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        m();
    }
}
