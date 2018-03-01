package books.thinkigInJava4ThEdition.chapters.concurrency.terminatingTasks.interruption;

import java.io.IOException;
import java.io.InputStream;
import java.util.stream.IntStream;

class IOBlocked implements Runnable {
    private InputStream in;

    IOBlocked(InputStream is){
        in = is;
    }

    @Override
    public void run() {
        try {
            System.out.println("waiting for read(): ");
            IntStream.range(0, 10).forEach(i->Thread.yield());
            in.read();
        } catch (IOException e) {
            if(Thread.currentThread().isInterrupted()){
                System.out.println("Interrupted from blocked I/O");
            }else{
                throw new RuntimeException();
            }
        }
        System.out.println("Exiting IOBlocked run");
    }
}
