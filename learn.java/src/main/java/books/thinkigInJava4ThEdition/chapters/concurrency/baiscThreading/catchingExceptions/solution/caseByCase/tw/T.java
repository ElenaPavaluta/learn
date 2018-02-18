package books.thinkigInJava4ThEdition.chapters.concurrency.baiscThreading.catchingExceptions.solution.caseByCase.tw;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class T {

    static void m() {
        ExecutorService exec = Executors.newCachedThreadPool(r -> {
            Thread t = new Thread(r);
            t.setUncaughtExceptionHandler((th, e) -> System.out.println(e.getClass().getSimpleName()));
            return t;
        });
        exec.execute(()-> System.out.println("thread 1"));
        exec.execute(()->{throw new IllegalArgumentException();});
    }

    public static void main(String[] args) {
        m();
    }
}
