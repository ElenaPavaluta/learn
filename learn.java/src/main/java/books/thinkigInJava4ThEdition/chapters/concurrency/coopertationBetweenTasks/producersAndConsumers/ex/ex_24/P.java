package books.thinkigInJava4ThEdition.chapters.concurrency.coopertationBetweenTasks.producersAndConsumers.ex.ex_24;

import java.util.function.IntSupplier;

class P implements Runnable, IntSupplier {
    private int i;

    private Buffer b;

    public P(Buffer buffer) {
        this.b = buffer;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                int i = getAsInt();
                synchronized(b.buffer) {
                    while(b.index >= b.max) {
                        b.buffer.wait();
                    }
                    b.buffer[b.index++] = i;
                    b.buffer.notifyAll();
                }
            }
        } catch(InterruptedException e) {
            System.out.println("P interrupted");
        }
    }

    @Override
    public synchronized int getAsInt() {
        return i++;
    }
}
