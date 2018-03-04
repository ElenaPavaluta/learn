package books.thinkigInJava4ThEdition.chapters.concurrency.terminatingTasks.checkingForAnInterrupt;

import java.util.concurrent.TimeUnit;

class InterruptingIdiom {

    static void m() throws InterruptedException {
//        int i = 3000;
        int i = 2010;
        Thread t = new Thread(new Blocked());
        t.start();
        TimeUnit.MILLISECONDS.sleep(i);
        t.interrupt();
    }

    public static void main(String[] args) throws InterruptedException {
        m();
    }
}
