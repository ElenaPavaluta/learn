package oc.p.chapters._7_Concurrency.creatingThreadsWithExecutorService.submittingTasks.tw._1;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

class C implements Callable <Integer> {

    private static AtomicInteger ai = new AtomicInteger(0);

    @Override
    public Integer call() throws Exception {
        return ai.incrementAndGet();
    }
}
