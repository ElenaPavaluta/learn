package books.thinkigInJava._4ThEdition.chapters.concurrency.sharingResources.threadLocalStorage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

class Run {

    static void m() throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        IntStream.range(0, 5)
                 .forEach(i->exec.execute(new Accessor(i)));
        TimeUnit.SECONDS.sleep(3);
        exec.shutdownNow();
    }

    public static void main(String[] args) throws InterruptedException {
        m();
    }
}
