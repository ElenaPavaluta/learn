package books.thinkigInJava._4ThEdition.chapters.concurrency.coopertationBetweenTasks.producersAndConsumers.tw.p4;

import java.util.concurrent.TimeUnit;

class C {

    synchronized void m(){
        try {
            while(!Thread.interrupted()){
                System.out.println("entered createAndPopulate");
                wait();
            }
        }catch(InterruptedException e){
            System.out.println("createAndPopulate interrupted");
        }
    }

    void m2(){
        synchronized(this){
            try {
                while(!Thread.interrupted()) {
                    System.out.println("m2 entered");
                    wait();
                }
            }catch(InterruptedException e){
                System.out.println("m2 interrupted");
            }
        }
    }

    void m3(){
        try {
            while(!Thread.interrupted()){
                System.out.println("m3 entered");
                TimeUnit.MILLISECONDS.sleep(500);
            }
        }catch(InterruptedException e){
            System.out.println("m3 interrupted");
        }
    }
}
