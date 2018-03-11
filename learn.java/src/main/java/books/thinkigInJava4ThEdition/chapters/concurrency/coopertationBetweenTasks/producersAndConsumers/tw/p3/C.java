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
            while(!Thread.interrupted()) {
                try {
                    System.out.println(i);
                    wait();
//                    TimeUnit.MILLISECONDS.sleep(50);
                    System.out.println(i);
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
