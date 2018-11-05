package oc.p.chapters._7_Concurrency.creatingThreadsWithExecutorService.waitingForResults.future;

import java.util.concurrent.*;

/**
 * boolean isDone();
 *
 * boolean isCancelled()
 *
 * boolean cancel(boolean mayInterruptIfRunning)
 *
 * V get() throws InterruptedException, ExecutionException
 *
 * V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException;
 */
class FutureObj {
    static C c;
    static ExecutorService exec;
    static Future <Integer> future;

    static {
        c = new C(10, TimeUnit.SECONDS);
        exec = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }

    static void is() {
        future = exec.submit(c);
        System.out.println(future.isDone());  //false
        System.out.println(future.isCancelled());  //false
    }

    static void cancel(boolean mayInterruptIfRunning) throws InterruptedException {
        future = exec.submit(c);

        /**
         *
         * mayInterruptIfRunning parameter determines
         * whether the thread executing this task should be interrupted in
         * an attempt to stop the task
         *
         */
        System.out.println(future.cancel(mayInterruptIfRunning));

        System.out.println(future.isDone());
        System.out.println(future.isCancelled());
    }

    static void get() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        future = exec.submit(c);

        /**
         * Blocks until it has the result
         */
        int nb = future.get();
        long end = System.currentTimeMillis();
        System.out.println(nb);
        System.out.println("waited: " + (end - start) / 1000);

    }

    static void get(long l, TimeUnit tu) throws InterruptedException, ExecutionException, TimeoutException {
        future = exec.submit(c);
        int nb = future.get(l, tu);
        System.out.println(nb);
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
//        is();

//        cancel(false);
//        cancel(true);

//        get();

//        get(1, TimeUnit.SECONDS);  //TimeoutException
        get(11, TimeUnit.SECONDS);

        exec.shutdownNow();
    }

}
