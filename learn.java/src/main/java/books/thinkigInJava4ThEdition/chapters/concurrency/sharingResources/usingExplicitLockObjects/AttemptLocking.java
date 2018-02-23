package books.thinkigInJava4ThEdition.chapters.concurrency.sharingResources.usingExplicitLockObjects;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class AttemptLocking {

    private ReentrantLock lock = new ReentrantLock();

    void untimed() {
        boolean captured = lock.tryLock();

        try {
            System.out.println("tryLock(): " + captured);
        } finally {
            if(captured) lock.unlock();
        }
    }

    void timed() {
        boolean captured = false;
        try {
            captured = lock.tryLock(2, TimeUnit.SECONDS);
        } catch(InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println("tryLock(2, TimeUnit.SECONDS): " + captured);
        } finally {
            if(captured) lock.unlock();
        }
    }

    public static void main(String[] args) {
        final AttemptLocking al = new AttemptLocking();
        al.untimed();
        al.timed();

        new Thread(){
            {
                setDaemon(true);
            }
            @Override
            public void run() {
                al.lock.lock();
                System.out.println("acquired");
            }
        }.start();
        Thread.yield();
        al.untimed();
        al.timed();
    }
}