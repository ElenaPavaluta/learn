package oc.p.chapters._7_Concurrency.creatingThreadsWithExecutorService.waitingForResults.introducingCallable.tw;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

class C implements Callable <Integer> {
    private AtomicInteger ai = new AtomicInteger(1);

    {
        ai.getAndIncrement();
        ai.incrementAndGet();

        ai.getAndDecrement();
        ai.decrementAndGet();
    }

    @Override
    public Integer call() throws Exception {
        return ai.getAndIncrement();
    }
}
