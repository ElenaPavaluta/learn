package oc.p.chapters._7_Concurrency.creatingThreadsWithExecutorService.submittingTasks.tw._2;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class C implements Callable <Integer> {
    private static AtomicInteger ai = new AtomicInteger(0);

    @Override
    public Integer call() throws Exception {
        TimeUnit.HOURS.sleep(1);
        return ai.getAndIncrement();
    }
}
