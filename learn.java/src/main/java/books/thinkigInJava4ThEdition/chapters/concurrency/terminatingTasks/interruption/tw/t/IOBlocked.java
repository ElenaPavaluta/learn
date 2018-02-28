package books.thinkigInJava4ThEdition.chapters.concurrency.terminatingTasks.interruption.tw.t;

import java.io.IOException;
import java.io.InputStream;

class IOBlocked implements Runnable {
    private InputStream in;

    IOBlocked(InputStream is){
        in = is;
    }

    @Override
    public void run() {
        try {
            System.out.println("waiting for read(): ");
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
