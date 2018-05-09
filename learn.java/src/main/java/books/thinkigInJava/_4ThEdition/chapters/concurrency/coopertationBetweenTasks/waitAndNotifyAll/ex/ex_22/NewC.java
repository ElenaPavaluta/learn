package books.thinkigInJava._4ThEdition.chapters.concurrency.coopertationBetweenTasks.waitAndNotifyAll.ex.ex_22;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class NewC {
    private volatile boolean flag = false;

    public static void main(String[] args) {
        new NewC().m();
    }

    synchronized void setFlag() {
        try {
            System.out.println("sleep() for 2000 ms");
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch(InterruptedException e) {
            System.out.println("interrupted exception in setFlag()");
        }
        flag = true;
        System.out.println("set flag: " + flag);
        notifyAll();
    }

    synchronized void check() {
        while(!flag) {
            try {
                System.out.println("Check");
                wait();
                System.out.println("wait over, flag: " + flag);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        flag = !flag;
    }

    void m() {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(this::check);
        exec.execute(this::setFlag);
        exec.shutdown();
    }

}
