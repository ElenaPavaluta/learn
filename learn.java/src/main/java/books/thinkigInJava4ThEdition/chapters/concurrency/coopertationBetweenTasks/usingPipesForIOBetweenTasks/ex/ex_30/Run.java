package books.thinkigInJava4ThEdition.chapters.concurrency.coopertationBetweenTasks.usingPipesForIOBetweenTasks.ex.ex_30;

import java.util.concurrent.*;
import java.util.stream.IntStream;

class Run {

    private BlockingQueue<Character> queue = new LinkedBlockingQueue<>();
    Sender s = new Sender(queue);
    Receiver r = new Receiver(queue);

    void m() throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        IntStream.range(0, 10)
                 .forEach(i -> {
                     exec.execute(r);
                     exec.execute(s);
                 });
        TimeUnit.SECONDS.sleep(4);
        exec.shutdownNow();
    }

    public static void main(String[] args) throws InterruptedException {
        new Run().m();
    }
}
