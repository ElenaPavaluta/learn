package books.thinkigInJava._4ThEdition.chapters.concurrency.coopertationBetweenTasks.usingPipesForIOBetweenTasks;

import java.io.IOException;
import java.io.PipedWriter;
import java.util.Random;
import java.util.concurrent.TimeUnit;

class Sender implements Runnable {
    private Random rand = new Random(47);
    private PipedWriter out = new PipedWriter();

    @Override
    public void run() {
        try {
            while(true) {
                for(char c = 'A'; c < 'z'; c++) {
                    out.write(c);
                    TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
                }
            }
        } catch(InterruptedException e) {
            System.out.println("Sender interrupted");
        } catch(IOException e) {
            System.out.println("Sender IO exception");
        }
    }


    public PipedWriter getOut() {
        return out;
    }
}
