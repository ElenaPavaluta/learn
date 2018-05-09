package books.thinkigInJava._4ThEdition.chapters.concurrency.terminatingTasks.blockedByAMutex;

import java.util.concurrent.TimeUnit;

class Interrupting2 {

    static void m() throws InterruptedException {
        Thread t = new Thread(new Blocked2());
        t.start();
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Issuing t.interrupt");
        t.interrupt();
    }

    public static void main(String[] args) throws InterruptedException {
        m();
    }
}
