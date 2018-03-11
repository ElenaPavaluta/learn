package books.thinkigInJava4ThEdition.chapters.concurrency.coopertationBetweenTasks.producersAndConsumers.tw.p2;

import java.util.concurrent.TimeUnit;

class R implements Runnable {

    private int i;

    @Override
    public void run() {

        try {
            while(!Thread.interrupted()) {
                /**
                 * synchronize(this): the lock is acquired on the current obj.
                 * this means that no other thread can access no other synchronized
                 * method on the synchroized obj
                 */
                synchronized(this) {
                    TimeUnit.MILLISECONDS.sleep(200);
                    System.out.println("Should apper no other message after this one");
                    System.out.println("i: " + i);
                    /*
                    Commenting the wait() and one can see that the second task
                    which runs the increment() is continuously running
                     */
//                    wait();
                }
            }
        }catch(InterruptedException e){
            System.out.println("R interrupted");
        }
    }

    void increment(){
        while(true){
            i++;
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch(InterruptedException e) {
                System.out.println("increment interrupted");
            }
        }
    }
}
