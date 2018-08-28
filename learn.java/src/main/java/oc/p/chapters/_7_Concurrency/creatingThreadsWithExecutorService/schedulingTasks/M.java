package oc.p.chapters._7_Concurrency.creatingThreadsWithExecutorService.schedulingTasks;

import java.util.concurrent.*;

/**
 * public ScheduledFuture<?> schedule(Runnable command,
 * long delay,
 * TimeUnit unit)
 *
 * public <V> ScheduledFuture<V> schedule(Callable<V> callable,
 * long delay,
 * TimeUnit unit)
 *
 *
 * public ScheduledFuture<?> scheduleAtFixedRate(Runnable command,
 * long initialDelay,
 * long period,
 * TimeUnit unit);
 *
 * public ScheduledFuture<?> scheduleWithFixedDelay(Runnable command,
 * long initialDelay,
 * long delay,
 * TimeUnit unit)
 */
class M {

    static ScheduledExecutorService scheduledExecutorService;
    static Runnable r = () -> {
        System.out.println(Runnable.class.getSimpleName());
    };
    static Callable<String> c = () -> {
        return Callable.class.getSimpleName();
    };

    static {
        scheduledExecutorService = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());
    }

    static void tearDown() throws InterruptedException {
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
            System.out.println("awaitTermination: " + scheduledExecutorService.awaitTermination(10, TimeUnit.SECONDS));
        }
    }

    static void m() throws ExecutionException, InterruptedException {
        ScheduledFuture<?> scheduledFuture = scheduledExecutorService.schedule(r, 5, TimeUnit.SECONDS);
        System.out.println(scheduledFuture.getDelay(TimeUnit.SECONDS));
        System.out.println(scheduledFuture);
        System.out.println(scheduledFuture.get());  //null
    }

    static void m2() throws ExecutionException, InterruptedException {
        ScheduledFuture<String> scheduledFuture = scheduledExecutorService.schedule(c, 5, TimeUnit.SECONDS);
        System.out.println(scheduledFuture.getDelay(TimeUnit.SECONDS));
        System.out.println(scheduledFuture.get());
    }

    static void m3() throws ExecutionException, InterruptedException {
        ScheduledFuture<?> scheduledFuture = scheduledExecutorService.scheduleAtFixedRate(r, 0, 1, TimeUnit.SECONDS);
        System.out.println(scheduledFuture.getDelay(TimeUnit.SECONDS));  //1
        System.out.println(scheduledFuture.get());  //null
    }

    static void m4() throws ExecutionException, InterruptedException {
        ScheduledFuture<?> scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(r, 1, 1, TimeUnit.SECONDS);
        System.out.println(scheduledFuture.getDelay(TimeUnit.SECONDS));
        System.out.println(scheduledFuture.get());
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        m();
//        m2();
//        m3();
        m4();
        tearDown();
    }
}

