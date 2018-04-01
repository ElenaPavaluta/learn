package books.thinkigInJava4ThEdition.chapters.concurrency.simulation.distributingWork.ex.ex_38;

import java.util.concurrent.BrokenBarrierException;

abstract class Worker implements Runnable {

    protected Builder builder;
    private WorkerPool pool;
    private boolean work = false;

    public Worker(WorkerPool pool) {
        this.pool = pool;
    }

    synchronized void start(Builder builder) {
        this.builder = builder;
        work = true;
        notifyAll();
    }

    abstract void work();

    synchronized void stop() throws InterruptedException {
        work = false;
        builder = null;
        pool.release(this);
        while(work == false) {
            wait();
        }
    }

    @Override
    public void run() {
        try {
            stop();
            while(!Thread.interrupted()) {
                work();
                builder.getCyclicBarrier().await();
                stop();
            }
        } catch(InterruptedException e) {
            System.out.println(this + " interrupted");
        } catch(BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
        System.out.println(this  + " off");
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
