package books.thinkigInJava4ThEdition.chapters.concurrency.coopertationBetweenTasks.producersAndConsumers.tw.p2;

import java.util.concurrent.TimeUnit;

class R implements Runnable {

    private int i;

    @Override
    public void run() {

        try {
            while(!Thread.interrupted()) {
                synchronized(this) {
                    System.out.println("Should apper no other message after this one");
                    System.out.println("i: " + i);
                    wait();
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
                TimeUnit.MILLISECONDS.sleep(200);
            } catch(InterruptedException e) {
                System.out.println("increment interrupted");
            }
        }
    }
}
