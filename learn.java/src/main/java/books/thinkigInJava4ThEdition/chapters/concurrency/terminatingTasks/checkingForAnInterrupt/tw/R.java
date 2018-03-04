package books.thinkigInJava4ThEdition.chapters.concurrency.terminatingTasks.checkingForAnInterrupt.tw;

import java.util.concurrent.TimeUnit;

class R implements Runnable {
    @Override
    public void run() {
        int i = 0;
        int j = 0;

        while(i < 5) {
            System.out.println("Entered: " +i);
            Thread t = new Thread(){
                @Override
                public void run() {
                    try {
                        TimeUnit.MILLISECONDS.sleep(40);
                    } catch(InterruptedException e) {
                        System.out.println("sleep interrupted: "); //cannot access i: needs to be final or effective final
                    }
                }
            };
            t.start();
            try {
                t.join();
            } catch(InterruptedException e) {
                System.out.println("join interrupted: " + i);
            }
            System.out.println("Interrupt status of i " + i + " : " + Thread.interrupted());
            i++;
        }
    }

    static void m() throws InterruptedException {
        Thread t = new Thread(new R());
        t.start();
        TimeUnit.MILLISECONDS.sleep(100);
        t.interrupt();
        t.join();
    }

    public static void main(String[] args) throws InterruptedException {
        m();
    }
}
