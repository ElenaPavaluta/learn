package books.thinkigInJava4ThEdition.chapters.concurrency.newLibraryComponents.countDownLatch;

import java.util.concurrent.CountDownLatch;

//Waits on the CountDownLatch
class WaitingTask implements Runnable {
    private static int counter = 0;
    private final int id = counter;
    private final CountDownLatch latch;

    public WaitingTask(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            latch.await();
            System.out.println("Latch barrier passed for " + this);
        } catch(InterruptedException e) {
            System.out.println("WaitingTask interrupted");
        }
    }

    public String toString() {
        return String.format("WaitingTask %1$-3d ", id);
    }
}
