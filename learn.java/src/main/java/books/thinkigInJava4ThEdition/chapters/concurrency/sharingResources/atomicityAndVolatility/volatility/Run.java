package books.thinkigInJava4ThEdition.chapters.concurrency.sharingResources.atomicityAndVolatility.volatility;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;

class Run {

    static final int SIZE = 10;
    static CircularSet circularSet = new CircularSet(1000);
    static ExecutorService exec = Executors.newCachedThreadPool();

    static void m() throws InterruptedException {
        LongStream.range(0, SIZE)
                  .forEach(l -> exec.execute(new SerialChecker()));

        TimeUnit.MILLISECONDS.sleep((int) (Math.random() * 100));
        System.out.println("No duplicates detected");
        System.exit(0);

    }

    public static void main(String[] args) throws InterruptedException {
        m();
    }

    static class SerialChecker implements Runnable {
        @Override
        public void run() {
            while(true) {
                int serial = SerialNbGenerator.nxtSerialNb();
                if(circularSet.contains(serial)) {
                    System.out.println("Duplicate: " + serial);
                    System.exit(0);
                }
                circularSet.add(serial);
            }
        }
    }

}
