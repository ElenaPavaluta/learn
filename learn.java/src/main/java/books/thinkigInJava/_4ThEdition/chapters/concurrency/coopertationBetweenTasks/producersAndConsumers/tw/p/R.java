package books.thinkigInJava._4ThEdition.chapters.concurrency.coopertationBetweenTasks.producersAndConsumers.tw.p;

import java.util.concurrent.TimeUnit;

class R implements Runnable {

    private C c;

    public R(C c) {
        this.c = c;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                /**
                 * Once the lock on an abject is acquired, no other task can access that object
                 */
                synchronized(c) {
                    TimeUnit.MILLISECONDS.sleep(500);  //does not release the lock
                    System.out.println(c.n);
                    /**
                     * IllegalMonitorStateException: due to the fact that the acquired
                     * lock is on the c object, not on the current object
                     *
                     * The same thing happens for the notify() and notifyAll()
                     */
//                    wait();
//                    notify();
//                    notifyAll();
                    /**
                     * releases the lock;
                     * can only be called on the synchronized object;
                     * otherwise throws an IllegalMonitorStateException
                     */
                    c.wait();
                    System.out.println("After c.wait()");
                }
            }
        } catch(InterruptedException e) {
            System.out.println("interrupted exception");
        }
    }
}
