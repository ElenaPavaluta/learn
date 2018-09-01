package books.thinkigInJava._4ThEdition.chapters.concurrency.coopertationBetweenTasks.waitAndNotifyAll;

import java.util.concurrent.TimeUnit;

class WaxOn implements Runnable{
    private Car car;

    public WaxOn(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        try{
            while(!Thread.interrupted()){
                System.out.println("Wax on");
                    TimeUnit.MILLISECONDS.sleep(200);
                car.waxOn();
                car.waitForWaxOff();
            }
        }catch(InterruptedException e){
            System.out.println("Existing via interrupt");
        }
        System.out.println("Ending Wax On task");
    }
}
