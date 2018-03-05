package books.thinkigInJava4ThEdition.chapters.concurrency.coopertationBetweenTasks.notifyVsNotifyAll;

class Blocker {

    synchronized void waitingCall(){
        try {
            while(!Thread.interrupted()){
                wait();
                System.out.println("Thread: " + Thread.currentThread().getName());
            }
        } catch(InterruptedException e) {
            System.out.println("ok to exit this way");
        }
    }

    synchronized void prod(){
        notify();
    }

    synchronized void prodAll(){
        notifyAll();
    }
}
