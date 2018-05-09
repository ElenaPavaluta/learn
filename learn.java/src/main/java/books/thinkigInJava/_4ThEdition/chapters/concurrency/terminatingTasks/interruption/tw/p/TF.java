package books.thinkigInJava._4ThEdition.chapters.concurrency.terminatingTasks.interruption.tw.p;

import java.util.concurrent.ThreadFactory;

class TF implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setUncaughtExceptionHandler(new UEH());
        return t;
    }
}
