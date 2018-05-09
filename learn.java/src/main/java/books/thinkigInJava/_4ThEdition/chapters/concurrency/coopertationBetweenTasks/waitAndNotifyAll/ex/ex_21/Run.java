package books.thinkigInJava._4ThEdition.chapters.concurrency.coopertationBetweenTasks.waitAndNotifyAll.ex.ex_21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Run {

    static void m(){
        C c = new C();
        ExecutorService exec = Executors.newCachedThreadPool();
        Runnable r = c::w;
        Runnable r2 = c::sleep;
        exec.execute(r);
        exec.execute(r2);
        exec.shutdown();
    }

    public static void main(String[] args) {
        m();
    }
}
