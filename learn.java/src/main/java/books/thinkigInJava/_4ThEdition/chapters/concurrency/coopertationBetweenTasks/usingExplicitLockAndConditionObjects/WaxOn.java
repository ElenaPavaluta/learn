package books.thinkigInJava._4ThEdition.chapters.concurrency.coopertationBetweenTasks.usingExplicitLockAndConditionObjects;

import java.util.concurrent.TimeUnit;

class WaxOn implements Runnable {
    private Car car;

    public WaxOn(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()){
                System.out.println("wax on");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitingForBuffing();
            }
        }catch(InterruptedException e){
            System.out.println("WaxOn interrupted");
        }
        System.out.println("Ending WaxOn task");
    }
}
