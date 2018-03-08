package books.thinkigInJava4ThEdition.chapters.concurrency.coopertationBetweenTasks.producersAndConsumers.tw.p3;

import java.util.concurrent.TimeUnit;

class C {

    private int i = 006;

    void m007() {
        /**
         * Ensures that no other thread can access any other synchronized code block
         */
        synchronized(this) {
            i = 007;
            System.out.println(i);
            while(!Thread.interrupted()) {
                try {
//                    wait();
                    TimeUnit.DAYS.sleep(1);
                    System.out.println("out of wait");
                } catch(InterruptedException e) {
                    System.out.println("m007 interrupted");
                }
            }
        }
    }

    /*synchronized*/ void justM() {
//        synchronized(this) {
            while(i < Integer.MAX_VALUE) {
                i++;
            }
//        }
    }
}
