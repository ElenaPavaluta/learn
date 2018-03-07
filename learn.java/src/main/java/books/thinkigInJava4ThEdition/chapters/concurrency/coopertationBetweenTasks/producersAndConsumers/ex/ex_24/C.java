package books.thinkigInJava4ThEdition.chapters.concurrency.coopertationBetweenTasks.producersAndConsumers.ex.ex_24;

import java.util.function.IntConsumer;

class C implements Runnable, IntConsumer {
    private Buffer b;

    public C(Buffer b) {
        this.b = b;
    }

    @Override
    public void run() {
        try{
            while(!Thread.interrupted()){
                int i;
                synchronized(b.buffer){
                    while(b.index<=0){
                        b.buffer.wait();
                    }
                    i = b.buffer[b.index--];
                    b.buffer.notifyAll();
                }
                accept(i);
            }
        }catch(InterruptedException e){
            System.out.println("C interrupted");
        }
    }

    @Override
    public void accept(int value) {
        System.out.println(Thread.currentThread().getId() + " -> " +value );
    }
}
