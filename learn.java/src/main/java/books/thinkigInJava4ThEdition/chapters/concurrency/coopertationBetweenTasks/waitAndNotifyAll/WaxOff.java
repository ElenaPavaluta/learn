package books.thinkigInJava4ThEdition.chapters.concurrency.coopertationBetweenTasks.waitAndNotifyAll;

import java.util.concurrent.TimeUnit;

class WaxOff implements Runnable {
    private Car car;

    public WaxOff(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()){
                car.waitingForWaxOn();
                System.out.println("Wax off");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxOff();
            }
        }catch(InterruptedException e){
            System.out.println("Exiting via interrupt");
        }
        System.out.println("Ending Wax Off task");
    }
}
