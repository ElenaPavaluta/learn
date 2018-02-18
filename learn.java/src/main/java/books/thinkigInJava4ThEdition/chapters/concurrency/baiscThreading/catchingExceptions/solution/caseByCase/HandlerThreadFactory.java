package books.thinkigInJava4ThEdition.chapters.concurrency.baiscThreading.catchingExceptions.solution.caseByCase;

import java.util.concurrent.ThreadFactory;

class HandlerThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        System.out.println(this.getClass().getSimpleName() + " creating new Thread");
        Thread t = new Thread(r);
        System.out.println("created " + t.getName());
        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        System.out.println("eh = " + t.getUncaughtExceptionHandler().getClass().getSimpleName());
        return t;
    }
}
