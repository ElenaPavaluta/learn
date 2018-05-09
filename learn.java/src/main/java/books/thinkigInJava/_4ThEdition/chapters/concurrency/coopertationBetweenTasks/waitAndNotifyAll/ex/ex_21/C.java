package books.thinkigInJava._4ThEdition.chapters.concurrency.coopertationBetweenTasks.waitAndNotifyAll.ex.ex_21;

import java.util.concurrent.TimeUnit;

class C {

    synchronized void w(){
        System.out.println("w()");
        try {
            wait();
        } catch(InterruptedException e) {
            System.out.println("wait() interrupted");
        }
        System.out.println("Who's upset?");
    }

    synchronized void sleep(){
        try {
            System.out.println("sleep() for 1 sec");
            TimeUnit.SECONDS.sleep(1);
        } catch(InterruptedException e) {
            System.out.println("C interrupted");
        }
        notifyAll();
    }
}
