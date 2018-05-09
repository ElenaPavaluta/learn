package books.thinkigInJava._4ThEdition.chapters.concurrency.sharingResources.improperlyAccessingResources;

import java.util.concurrent.atomic.AtomicInteger;

abstract class IntGenerator {

    volatile boolean canceled = false;

    abstract int next();

    void cancel() {
        canceled = true;
    }

    boolean isCanceled() {
        return canceled;
    }
}

class ActualIntGenerator extends IntGenerator {
    @Override
    int next() {
        return (int) (Math.random() * 100);
    }
}

class EvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;

    /**
     * The increment operation is not an atomic operation,
     * which mean that, without proper protection the incremented
     * value can be in an inconsistent state
     */
    @Override
    int next() {
        ++currentEvenValue; //Danger point here
        ++currentEvenValue;
        return currentEvenValue;
    }
}

class SynchronizedEvenGenerator extends IntGenerator{
    private int currentEvenValue = 0;

    @Override
    synchronized int next() {
        ++currentEvenValue;
        Thread.yield();  //Cause failure faster
        ++currentEvenValue;
        return currentEvenValue;
    }
}

class AtomicEvenGenerator extends IntGenerator{
    private AtomicInteger ai = new AtomicInteger(0);
    @Override
    int next() {
        return ai.getAndAdd(2);
    }
}
