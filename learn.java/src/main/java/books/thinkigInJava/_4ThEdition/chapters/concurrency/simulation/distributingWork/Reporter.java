package books.thinkigInJava._4ThEdition.chapters.concurrency.simulation.distributingWork;

class Reporter implements Runnable {
    private CarQueue carQueue;

    public Reporter(CarQueue carQueue) {
        this.carQueue = carQueue;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()){
                System.out.println(carQueue.take());
            }
        } catch(InterruptedException e) {
            System.out.println(this + " interrupted");
        }
        System.out.println(this + " off");
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
