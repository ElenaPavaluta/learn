package books.thinkigInJava4ThEdition.chapters.concurrency.baiscThreading.codingVariations;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

class InnerRunnable2 {
    int countDown = 5;
    Thread t;

    InnerRunnable2(String name) {
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(true) {
                        System.out.println(this);
                        if(--countDown == 0) return;
                        TimeUnit.MILLISECONDS.sleep(10);
                    }
                } catch(InterruptedException e) {
                    System.out.println("sleep() interrupted");
                }
            }

            public String toString() {
                return Thread.currentThread().getName() +
                        ": " + countDown;
            }


        }, name);
        t.start();
    }

    public static void main(String[] args) {
        IntStream.rangeClosed(1,5)
                 .forEach(i-> new InnerRunnable2(Integer.toString(i)));
    }
}
