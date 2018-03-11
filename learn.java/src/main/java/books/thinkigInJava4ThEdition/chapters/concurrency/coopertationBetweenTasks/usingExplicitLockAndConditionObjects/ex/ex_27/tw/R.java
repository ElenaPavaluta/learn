package books.thinkigInJava4ThEdition.chapters.concurrency.coopertationBetweenTasks.usingExplicitLockAndConditionObjects.ex.ex_27.tw;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class R {

    M meal;
    W waiter = new W(this);
    C chef = new C(this);

    void m() throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(waiter);
        exec.execute(chef);
        TimeUnit.SECONDS.sleep(3);
        exec.shutdownNow();
    }

    public static void main(String[] args) throws InterruptedException {
        new R().m();
    }
}
