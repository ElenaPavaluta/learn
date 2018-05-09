package books.thinkigInJava._4ThEdition.chapters.concurrency.coopertationBetweenTasks.producersAndConsumers.ex.ex_24;


import java.util.concurrent.TimeUnit;

class C implements Runnable {

    private Buffer b;

    public C(Buffer b) {
        this.b = b;
    }

    @Override
    public void run() {
        while(!Thread.interrupted()) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                int i;
                synchronized(this) {
                    while(b.empty()) {
                        wait();
                        System.out.println("T " + Thread.currentThread().getId() + " waited");
                    }
                }
                synchronized(b) {
                    if(!b.empty()) {
                        i = b.remove();
                    }else{
                        b.wait();
                    }
                    b.notifyAll();
                }
            } catch(InterruptedException e) {
                System.out.println("C interrupted: " + Thread.currentThread().getId());
            }
        }
    }
}
