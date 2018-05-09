package books.thinkigInJava._4ThEdition.chapters.concurrency.terminatingTasks.becomingBlocked.tw;

import java.util.concurrent.TimeUnit;

class Wait implements Runnable{
    boolean b = true;
    @Override
    public void run() {
        System.out.println("wait() blocking");
        while(b){
            int i = 23;
            i = (int)(i * Math.random() +Math.E)%(23*6/9 + i);
            System.out.println(i);
            try {
                TimeUnit.MILLISECONDS.sleep(10);
                System.out.println("sleep 10 ms");
            } catch(InterruptedException e) {
                System.out.println("sleep interrupted");
            }
            try {
                wait();
            } catch(InterruptedException e) {
                System.out.println("wait interrupted");
            }
        }
    }

    static void m() throws InterruptedException {
        Thread t = new Thread(new Wait());
        t.start();
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("t wait()");
        t.wait();

    }

    public static void main(String[] args) throws InterruptedException {
        m();
    }
}
