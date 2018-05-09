package books.thinkigInJava._4ThEdition.chapters.concurrency.coopertationBetweenTasks.usingExplicitLockAndConditionObjects;

import java.util.concurrent.TimeUnit;

class WaxOff implements Runnable{
   private Car car;

    public WaxOff(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        try{
            while(!Thread.interrupted()){
                car.waitingForWaxing();
                System.out.println("wax off");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();
            }
        }catch(InterruptedException e){
            System.out.println("WaxOff interrupted");
        }
        System.out.println("Exiting WaxOff task");
    }
}
