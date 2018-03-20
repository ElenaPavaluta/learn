package books.thinkigInJava4ThEdition.chapters.concurrency.newLibraryComponents.semaphore.tw;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

class Run {

    ExecutorService exec = Executors.newCachedThreadPool();
    Pool pool = new Pool(5);

    void m() throws InterruptedException {
        exec.execute(pool);
        IntStream.range(0, 10).forEach(i->exec.execute(new Task(i, pool)));

        TimeUnit.SECONDS.sleep(10);
        exec.shutdownNow();
    }

    public static void main(String[] args) throws InterruptedException {
        new Run().m();
    }
}
