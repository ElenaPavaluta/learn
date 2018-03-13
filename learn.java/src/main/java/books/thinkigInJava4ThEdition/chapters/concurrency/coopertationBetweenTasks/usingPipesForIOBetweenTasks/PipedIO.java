package books.thinkigInJava4ThEdition.chapters.concurrency.coopertationBetweenTasks.usingPipesForIOBetweenTasks;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Sender and Receiver represent tasks that need to communicate
 * with each other. Sender creates a PipedWriter, which is a
 * standalone object, but inside Receiver the creation of PipedReader
 * must be associated with a PipedWriter in the constructor.
 * The Sender puts data into the Writer and sleeps for a random amount
 * of time. However, Receiver has no sleep( ) or wait( ).
 * But when it does a read( ), the pipe automatically blocks when
 * there is no more data.
 */
class PipedIO {

    static void m() throws IOException, InterruptedException {
        Sender sender = new Sender();
        Receiver receiver = new Receiver(sender);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(sender);
        exec.execute(receiver);
        TimeUnit.SECONDS.sleep(10);
        exec.shutdownNow();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        m();
    }
}
