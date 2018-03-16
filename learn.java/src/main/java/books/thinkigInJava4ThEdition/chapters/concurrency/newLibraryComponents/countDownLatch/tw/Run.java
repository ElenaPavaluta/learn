package books.thinkigInJava4ThEdition.chapters.concurrency.newLibraryComponents.countDownLatch.tw;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.zip.Adler32;

class Run {

    int n = 10;
    ExecutorService exec = Executors.newCachedThreadPool();
    Square square = new Square(n);
    CountDownLatch countDownLatch = new CountDownLatch((int) (Math.pow(n, 2)));

    public static void main(String[] args) throws InterruptedException {
        new Run().m();
    }

    void m() throws InterruptedException {
        for(int i = 0; i < n; i++) {
            exec.execute(new Printer(square, countDownLatch));
        }
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Slepped a bit");
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                exec.execute(new Setter(square, countDownLatch, i, j));
            }
        }
        exec.shutdown();

    }
}
