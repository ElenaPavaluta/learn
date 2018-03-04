package books.thinkigInJava4ThEdition.chapters.concurrency.terminatingTasks.checkingForAnInterrupt.tw;

import javax.sound.midi.SoundbankResource;
import java.util.concurrent.TimeUnit;

class R2 implements Runnable {
    double d;
    boolean b;

    @Override
    public void run() {
        System.out.println("entered run");
        while(true){
            if(b = Thread.interrupted()){
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("\n\n\n " + b + "\n\n\n");
                } catch(InterruptedException e) {
                    System.out.println("sleep() interrupted");
                }
            }
            d = Math.random() * Math.random() / Math.random() + Math.E - Math.PI;

        }
    }

    static void m() throws InterruptedException {
        Thread t = new Thread(new R2());
        t.start();
        t.interrupt();
        TimeUnit.SECONDS.sleep(3);
        t.interrupt();
    }

    public static void main(String[] args) throws InterruptedException {
        m();
    }
}
