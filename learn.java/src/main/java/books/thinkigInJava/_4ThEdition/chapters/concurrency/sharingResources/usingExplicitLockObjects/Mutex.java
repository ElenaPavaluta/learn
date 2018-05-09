package books.thinkigInJava._4ThEdition.chapters.concurrency.sharingResources.usingExplicitLockObjects;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.LongStream;

class Mutex {

    private int i;
    private Lock lock = new ReentrantLock();

    /**
     * When you are using Lock objects,
     * it is important to internalize the idiom shown here:
     * Right after the call to lock( ),
     * you must place a try-finally statement with unlock( )
     * in the finally clause
     * —this is the only way to guarantee that the lock
     * is always released. Note
     * that the return statement must occur inside the
     * try clause to ensure that the unlock( )
     * doesn’t happen too early and expose the data to a second task.
     */
    void m() {
        lock.lock();
        try {
            Thread.yield();
            i++;
            Thread.yield();
            ++i;
            Thread.yield();
            i++;
            try {
                TimeUnit.MILLISECONDS.sleep((int)(Math.random()*10));
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            Thread.yield();
            System.out.println(i);
            Thread.yield();
        } finally {
            lock.unlock();
        }
    }

    static void run(){
        ExecutorService exec = Executors.newCachedThreadPool();
        Mutex m = new Mutex();
        LongStream.range(1,10)
                  .forEach(l->exec.execute(m::m));
        exec.shutdown();
    }

    public static void main(String[] args) {
        run();
    }
}
