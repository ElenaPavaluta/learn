package books.thinkigInJava4ThEdition.chapters.concurrency.coopertationBetweenTasks.waitAndNotifyAll;

class Car {

    private boolean waxOn = false;

    synchronized void waxOn(){
        waxOn = true;  //ready to buff
        notifyAll();
    }

    synchronized void waxOff(){
        waxOn = false;
        notifyAll();
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
