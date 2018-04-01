package books.thinkigInJava4ThEdition.chapters.concurrency.simulation.distributingWork.ex.ex_38;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class Builder implements Runnable {

    House house;
    private WorkerPool pool;
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(7);

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                pool.hire(FoundationWorker.class, this);
                cyclicBarrier.await();
            }
        } catch(InterruptedException e) {
            System.out.println(this + " interrupted");
        } catch(BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }

    House getHouse() {
        return house;
    }

    public CyclicBarrier getCyclicBarrier() {
        return cyclicBarrier;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
