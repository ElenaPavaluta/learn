package books.thinkigInJava._4ThEdition.chapters.concurrency.simulation.distributingWork.ex.ex_38;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class Builder implements Runnable {

    House house;
    private WorkerPool pool;
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(7);

    public Builder(WorkerPool pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                house = new House();
                pool.hire(FoundationWorker.class, this);
                pool.hire(FrameWorker.class, this);
                pool.hire(RoofWorker.class, this);
                pool.hire(WindowWorker.class, this);
                pool.hire(DoorWorker.class, this);
                pool.hire(NbWorker.class, this);
                cyclicBarrier.await();
                house.print();
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
