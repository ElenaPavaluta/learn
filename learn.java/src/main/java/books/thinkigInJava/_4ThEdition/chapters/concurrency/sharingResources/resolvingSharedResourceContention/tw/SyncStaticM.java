package books.thinkigInJava._4ThEdition.chapters.concurrency.sharingResources.resolvingSharedResourceContention.tw;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

class SyncStaticM {

    private static int a;

    synchronized static void staticM(){
        System.out.println(Thread.currentThread().getName());
        a++;
        a++;
        System.out.println(a);
        System.out.println();
    }

    static void m() throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        IntStream.rangeClosed(0,10).forEach(i->exec.execute(()->SyncStaticM.staticM()));
        exec.shutdown();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(a);
    }

    public static void main(String[] args) throws InterruptedException {
        m();
    }
}
