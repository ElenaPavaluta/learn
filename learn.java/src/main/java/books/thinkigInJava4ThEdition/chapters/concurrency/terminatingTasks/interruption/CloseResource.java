package books.thinkigInJava4ThEdition.chapters.concurrency.terminatingTasks.interruption;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class CloseResource {

    static void m() throws IOException, InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
       /* ServerSocket server =*/ new ServerSocket(8080);
        InputStream socketInput = new Socket("localhost", 8080).
                                                                       getInputStream();
        exec.execute(new IOBlocked(socketInput));
        exec.execute(new IOBlocked(System.in));
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("Shutting down all threads");
        exec.shutdownNow();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Closing " + socketInput.getClass().getSimpleName());
        socketInput.close();  //release blocking thread
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Closing " + System.in.getClass().getSimpleName());
        System.in.close();  //release blocking thread
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        m();
    }
}
