package books.thinkigInJava._4ThEdition.chapters.concurrency.sharingResources.resolvingSharedResourceContention.tw;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class SyncMethodStackTrace {
    private int a;

    synchronized void a(){
        System.out.println(Thread.holdsLock(this));  //true
        b();
        d();  //true

    }

    synchronized void b(){
        inc();
    }

    synchronized void inc(){
        a++;
    }

    synchronized void dec(){
        a--;
    }

    void d(){
        System.out.println(Thread.holdsLock(this));
    }

    synchronized int getA(){
        return a;
    }
}

class Run2{
    SyncMethodStackTrace s = new SyncMethodStackTrace();
    Runnable inc = ()->s.a();
    Runnable dec = ()->s.dec();

    void m() throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(inc);
        exec.execute(dec);
        exec.shutdown();
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println(s.getA());
        s.d();
    }

    public static void main(String[] args) throws InterruptedException {
        new Run2().m();
    }
}
