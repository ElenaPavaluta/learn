package books.thinkigInJava4ThEdition.chapters.concurrency.deadlock;

import java.util.Random;
import java.util.concurrent.TimeUnit;

class Philosopher implements Runnable {
    protected Chopstick left;
    protected Chopstick right;

    protected final int id;
    protected final int ponderFactor;
    protected Random rand = new Random(47);

    Philosopher(Chopstick left, Chopstick right, int id, int ponderFactor) {
        this.left = left;
        this.right = right;
        this.id = id;
        this.ponderFactor = ponderFactor;
    }

    void pause() throws InterruptedException{
        if(ponderFactor == 0){
            return;
        }
        TimeUnit.MILLISECONDS.sleep(rand.nextInt(ponderFactor * 250));
    }

    @Override
    public void run() {
        try{
            while (!Thread.interrupted()){
                System.out.println(this.id + " thinking");
                pause();
                //philosopher becomes hungry
                System.out.println(this.id + " grabbing right");
                right.take();
                System.out.println(this.id + " grabbing left");
                left.take();
                System.out.println(this.id + " eating");
                pause();
                right.drop();
                left.drop();
            }
        }catch (InterruptedException e){
            System.out.println(this.id + " exiting via interrupt()");
        }
    }
}
