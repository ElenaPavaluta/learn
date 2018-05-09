package books.thinkigInJava._4ThEdition.chapters.concurrency.baiscThreading.daemonThreads.p;

import java.util.concurrent.ThreadFactory;

class DaemonThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}
