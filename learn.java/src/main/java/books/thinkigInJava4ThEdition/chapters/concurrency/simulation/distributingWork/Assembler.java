package books.thinkigInJava4ThEdition.chapters.concurrency.simulation.distributingWork;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class Assembler implements Runnable {
    private CarQueue chassisQueue, finishingQueue;
    private Car car;
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(4);
    private RobotPool robotPool;

    public Assembler(CarQueue chassisQueue, CarQueue finishingQueue, RobotPool robotPool) {
        this.chassisQueue = chassisQueue;
        this.finishingQueue = finishingQueue;
        this.robotPool = robotPool;
    }

    Car car(){
        return car;
    }

    CyclicBarrier cyclicBarrier(){
        return cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()){
                car = chassisQueue.take();
                robotPool.hire(EngineRobot.class, this);
                robotPool.hire(DriveTrainRobot.class, this);
                robotPool.hire(WheelRobot.class, this);
                cyclicBarrier.await();
                finishingQueue.put(car);
            }
        } catch(InterruptedException e) {
            System.out.println(this + " interrupted");
        } catch(BrokenBarrierException e) {
            //this one we want to know about
            throw new RuntimeException(e);
        }
        System.out.println(this + " off");
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
