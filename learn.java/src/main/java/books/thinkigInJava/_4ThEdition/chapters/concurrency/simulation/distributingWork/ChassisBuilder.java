package books.thinkigInJava._4ThEdition.chapters.concurrency.simulation.distributingWork;

import java.util.concurrent.TimeUnit;

class ChassisBuilder implements Runnable {
    private CarQueue carQueue;
    private int counter = 0;

    public ChassisBuilder(CarQueue carQueue) {
        this.carQueue = carQueue;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(500);
                Car c = new Car(++counter);
                System.out.println(this + " created: " + c);
                carQueue.put(c);
            }
        } catch(InterruptedException e) {
            System.out.println(this + " interrupted");
        }
        System.out.println(this + " off");
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
