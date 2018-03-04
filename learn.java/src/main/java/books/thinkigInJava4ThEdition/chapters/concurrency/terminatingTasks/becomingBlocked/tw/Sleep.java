package books.thinkigInJava4ThEdition.chapters.concurrency.terminatingTasks.becomingBlocked.tw;

import java.util.concurrent.TimeUnit;

class Sleep implements Runnable{

    @Override
    public void run() {
        try {
            System.out.println("sleep() blocking");
            TimeUnit.SECONDS.sleep(2);
        } catch(InterruptedException e) {
            System.out.println("interrupt");
        }
    }

    static void m(){
        Thread t = new Thread(new Sleep());
        t.start();
        t.interrupt();
    }

    public static void main(String[] args) {
        m();
    }
}
