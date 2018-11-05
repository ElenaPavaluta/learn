package oc.p.chapters._7_Concurrency.creatingThreadsWithExecutorService.increasingConcurrencyWithPools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

class M {

    static ExecutorService executorService;
    static ScheduledExecutorService scheduledExecutorService;

    static {
        executorService = Executors.newSingleThreadExecutor();
        executorService = Executors.newSingleThreadScheduledExecutor();

        executorService = Executors.newCachedThreadPool();

        executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        executorService = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());
    }

    static {
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());
    }
}
