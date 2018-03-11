package books.thinkigInJava4ThEdition.chapters.concurrency.coopertationBetweenTasks.producersAndConsumers.ex.ex_24;

class P implements Runnable {
    private int i;
    private Buffer b;

    public P(Buffer b) {
        this.b = b;
    }

    @Override
    public void run() {
        while(!Thread.interrupted()) {
            try {
                int i;
                synchronized(this) {
                    while(b.full()) {
                        wait();
                        System.out.println("T " + Thread.currentThread().getId() + " waited");
                    }
                }
                i = increment();
                System.out.println(i);
                synchronized(b) {
                    if(!b.full()) {
                        b.add(i);
                    } else {
                        b.wait();
                    }
                    b.notifyAll();
                }
            } catch(InterruptedException e) {
                System.out.println("P interrupted: " + Thread.currentThread().getId());
            }
        }
    }

    synchronized int increment() {
        return i++;
    }
}
