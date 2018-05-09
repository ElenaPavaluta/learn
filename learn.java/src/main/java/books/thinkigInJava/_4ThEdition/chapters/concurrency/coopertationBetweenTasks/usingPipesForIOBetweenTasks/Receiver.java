package books.thinkigInJava._4ThEdition.chapters.concurrency.coopertationBetweenTasks.usingPipesForIOBetweenTasks;

import java.io.IOException;
import java.io.PipedReader;

class Receiver implements Runnable {
    private PipedReader in;

    Receiver(Sender sender) throws IOException {
        in = new PipedReader(sender.getOut());
    }

    @Override
    public void run() {
        try {
            while(true) {
                //block until characters are there
                System.out.println("Read: " + (char) in.read());
            }
        } catch(IOException e) {
            System.out.println("Reveiver read exception:  " + e);
        }
    }
}
