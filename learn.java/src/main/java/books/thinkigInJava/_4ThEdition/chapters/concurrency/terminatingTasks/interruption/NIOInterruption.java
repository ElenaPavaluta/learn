package books.thinkigInJava._4ThEdition.chapters.concurrency.terminatingTasks.interruption;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class NIOInterruption {

    static void m() throws IOException, InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        ServerSocket server = new ServerSocket(8080);

        InetSocketAddress isa =
                new InetSocketAddress("localhost", 8080);
        SocketChannel sc = SocketChannel.open(isa);
        SocketChannel sc2 = SocketChannel.open(isa);

        Future<?> f = exec.submit(new NIOBlocked(sc));
        exec.execute(new NIOBlocked(sc2));

        exec.shutdown();

        TimeUnit.SECONDS.sleep(1);
        f.cancel(true);  //produce an interrupt
        TimeUnit.SECONDS.sleep(1);
        sc2.close();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        m();
    }
}
