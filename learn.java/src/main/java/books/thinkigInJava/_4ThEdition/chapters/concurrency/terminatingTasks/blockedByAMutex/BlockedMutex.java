package books.thinkigInJava._4ThEdition.chapters.concurrency.terminatingTasks.blockedByAMutex;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BlockedMutex {

    private Lock lock = new ReentrantLock();

    BlockedMutex() {
        System.out.println("Locking thread: " + Thread.currentThread().getId());
        lock.lock();
    }

    void f() {
        try {
            //This will never be available to a second task
            lock.lockInterruptibly();
            System.out.println("lock acquired in f()");
        } catch(InterruptedException e) {
            System.out.println("Interrupted from lock acquisition in f()");
        }
    }
}
