package books.thinkigInJava._4ThEdition.chapters.concurrency.coopertationBetweenTasks.waitAndNotifyAll;

class Car {

    private boolean waxOn = false;

    synchronized void waxOn(){
        waxOn = true;  //ready to buff
//        notifyAll();
        notify();
    }

    synchronized void waxOff(){
        waxOn = false;
//        notifyAll();
        notify();
    }

    synchronized void waitingForWaxOn() throws InterruptedException {
        while(waxOn==false){
            wait();
        }
    }

    synchronized void waitForWaxOff() throws InterruptedException{
        while(waxOn == true){
            wait();
        }
    }
}
