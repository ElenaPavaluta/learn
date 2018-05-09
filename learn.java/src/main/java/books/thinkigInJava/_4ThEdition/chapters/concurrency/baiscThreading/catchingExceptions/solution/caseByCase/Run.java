package books.thinkigInJava._4ThEdition.chapters.concurrency.baiscThreading.catchingExceptions.solution.caseByCase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Run {

    static void m(){
        System.out.println(Thread.currentThread().getName());
        ExecutorService exec = Executors.newCachedThreadPool(new HandlerThreadFactory());
        exec.execute(new ExceptionThread());
    }

    public static void main(String[] args) {
        m();
    }
}
