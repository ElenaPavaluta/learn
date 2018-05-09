package books.thinkigInJava._4ThEdition.chapters.concurrency.sharingResources.atomicityAndVolatility.atomicity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.LongStream;

class Atomicity implements Runnable {

    /**
     * Making the field volative doesn't solve the problem since
     * the volatile keyword only ensures that the read/write
     * ops work directly  with the main memory and not with the thread
     * (possible) own copy
     *
     */
    private /*volatile*/ int i = 0;

    public static void main(String[] args) {
        m();
    }

    private static void m() {
        ExecutorService exec = Executors.newCachedThreadPool();
        Atomicity at = new Atomicity();
        LongStream.range(1, 10).forEach(l -> exec.execute(at));
        while(true) {
            int val = at.getI();
            if(val % 2 != 0) {
                System.out.println(val);
                System.exit(0);
            }
        }
    }

    /**
     * this method can read data in an inconsistent
     * state(when i is an odd nb: basically this issue ensures
     * that the program exits)
     */
    /*synchronized*/ int getI() {
        return i;
    }

    synchronized private void evenIncrement() {
        i++;  //not an atomic operation
        i++;
    }

    public void run() {
        while(true) {
            evenIncrement();
        }
    }
}
