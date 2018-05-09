package books.thinkigInJava._4ThEdition.chapters.concurrency.simulation.distributingWork;

import java.util.concurrent.BrokenBarrierException;

abstract class Robot implements Runnable {
    private RobotPool pool;
    protected Assembler assembler;
    private boolean engage = false;

    public Robot(RobotPool pool) {
        this.pool = pool;
    }

    Robot assignAssembler(Assembler assembler){
        this.assembler = assembler;
        return this;
    }

    synchronized void engage(){
        engage = true;
        notifyAll();
    }
    
    abstract void performService();

    @Override
    public void run() {
        try{
            powerDown();
            while(!Thread.interrupted()){
                performService();
                assembler.cyclicBarrier().await();
                powerDown();
            }
        } catch(InterruptedException e) {
            System.out.println(this + " interrupted");
        } catch(BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
        System.out.println(this + " off");
    }


    private synchronized void powerDown() throws InterruptedException {
        engage =false;
        assembler = null;  //disconects from the assembler
        //put orselg back in the available pool
        pool.release(this);
        while(engage ==false){
            wait();
        }
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
