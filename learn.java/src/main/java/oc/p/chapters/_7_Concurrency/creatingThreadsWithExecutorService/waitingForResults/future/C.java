package oc.p.chapters._7_Concurrency.creatingThreadsWithExecutorService.waitingForResults.future;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class C implements Callable <Integer> {
    private AtomicInteger ai = new AtomicInteger(0);

    private TimeUnit tu;
    private int sleep;

    C(final int sleep, final TimeUnit tu) {
        this.tu = tu;
        this.sleep = sleep;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("call started");
        tu.sleep(sleep);
        return ai.incrementAndGet();
    }
}
