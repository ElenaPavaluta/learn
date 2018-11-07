package oc.p.chapters._7_Concurrency.creatingThreadsWithExecutorService.waitingForResults.waitingForAllTasksToFinish.tw._3;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.LongStream;

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
    AtomicLong al = new AtomicLong(0);
    Random r = new Random(47);

    void m() {
        ExecutorService exec;
        try {
            exec = Executors.newCachedThreadPool();
            LongStream.rangeClosed(1, 10)
                    .mapToObj(l -> new C())
                    .forEach(exec::submit);
            System.out.println(exec.awaitTermination(10, TimeUnit.SECONDS));
            System.out.println(al.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {

        }
    }

    class C implements Callable <Long> {
        @Override
        public Long call() throws Exception {
            TimeUnit.MILLISECONDS.sleep(r.nextInt(1000));
            return al.incrementAndGet();
        }
    }

    public static void main(String[] args) {
        new AT().m();
    }
}
