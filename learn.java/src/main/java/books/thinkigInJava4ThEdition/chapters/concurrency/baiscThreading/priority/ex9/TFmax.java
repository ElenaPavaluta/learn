package books.thinkigInJava4ThEdition.chapters.concurrency.baiscThreading.priority.ex9;

import java.util.concurrent.ThreadFactory;

class TFmax implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setPriority(Thread.MAX_PRIORITY);
        return t;
    }
}
