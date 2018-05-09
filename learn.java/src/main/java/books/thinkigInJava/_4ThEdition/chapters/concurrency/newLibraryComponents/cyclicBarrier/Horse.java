package books.thinkigInJava._4ThEdition.chapters.concurrency.newLibraryComponents.cyclicBarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class Horse implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private int strides = 0;
    private static Random rand = new Random(47);

    private static CyclicBarrier barrier;

    Horse(CyclicBarrier barrier){
        this.barrier = barrier;
    }

    synchronized int getStrides(){
        return strides;
    }

    @Override
    public void run() {
        try{
            while(!Thread.interrupted()){
                synchronized(this){
                    strides +=rand.nextInt(3);  //produces 0, 1, 2;
                }
                barrier.await();
            }
        }catch(InterruptedException e){
            System.out.println("legitimate way tp exit");
        } catch(BrokenBarrierException e) {
           //This one we want to know about
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Horse " + id + " ";
    }

    String tracks(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<getStrides(); i++){
            sb.append("*");
    }
        sb.append(id);
        return sb.toString();
    }
}
