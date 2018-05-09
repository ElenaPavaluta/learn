package books.thinkigInJava._4ThEdition.chapters.concurrency.baiscThreading.priority.ex9;

import java.util.concurrent.ThreadFactory;

class TFmin implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setPriority(Thread.MIN_PRIORITY);
        return t;
    }
}
