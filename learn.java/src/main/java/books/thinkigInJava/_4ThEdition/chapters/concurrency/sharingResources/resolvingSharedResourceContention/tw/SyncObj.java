package books.thinkigInJava._4ThEdition.chapters.concurrency.sharingResources.resolvingSharedResourceContention.tw;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class SyncObj {

    private int a = 0;

    synchronized void increment() {
        a++;
    }

    synchronized void decrement() {
        a--;
    }

    synchronized int getA() {
        return a;
    }
}

class Run {
    SyncObj s = new SyncObj();
    Runnable inc = ()->s.increment();
    Runnable dec = ()->s.decrement();

    void m() throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i<10; i++){
            exec.execute(inc);
            exec.execute(dec);
        }
        exec.shutdown();
        TimeUnit.SECONDS.sleep(1);  //waiting for all threads to complete their work
        System.out.println(s.getA());
    }

    public static void main(String[] args) throws InterruptedException {
        new Run().m();
    }
}
