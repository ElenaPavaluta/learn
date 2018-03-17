package books.thinkigInJava4ThEdition.chapters.concurrency.newLibraryComponents.countDownLatch.ex_32;

import java.util.Random;

class Count {

    private int count = 0;
    private Random rand = new Random(47);


    synchronized int increment(){
        int temp = count;
        if(rand.nextBoolean()){
            Thread.yield();
        }
        return count = ++temp;
    }

    synchronized int value(){
        return count;
    }
}
