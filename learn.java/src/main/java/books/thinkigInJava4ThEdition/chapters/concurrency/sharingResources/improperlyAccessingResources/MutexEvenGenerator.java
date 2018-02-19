package books.thinkigInJava4ThEdition.chapters.concurrency.sharingResources.improperlyAccessingResources;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MutexEvenGenerator extends IntGenerator {
    int currentValue = 0;

    private Lock lock = new ReentrantLock();

    @Override
    int next() {
        lock.lock();
        try{
            ++currentValue;
            Thread.yield();
            currentValue++;
            return currentValue;
        }finally {
            lock.unlock();
        }
    }
}
