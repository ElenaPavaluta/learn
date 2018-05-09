package books.thinkigInJava._4ThEdition.chapters.concurrency.terminatingTasks.theOrnamentalGarden;

import java.util.Random;

class Count {

    private int count = 0;
    private Random rand = new Random(47);

    //remove the synchronized keyword to see counting fail
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
