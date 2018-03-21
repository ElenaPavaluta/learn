package books.thinkigInJava4ThEdition.chapters.concurrency.newLibraryComponents.exchanger;

import java.util.List;
import java.util.concurrent.Exchanger;

class ExchangerConsumer<T> implements Runnable {

    private Exchanger<List<T>> exchanger;
    private List<T> holder;
    private volatile  T value;

    public ExchangerConsumer(Exchanger<List<T>> exchanger, List<T> holder) {
        this.exchanger = exchanger;
        this.holder = holder;
    }

    @Override
    public void run() {
        try{
            while(!Thread.interrupted()){
                holder = exchanger.exchange(holder);
                holder.forEach(x->{
                    value = x;
                    holder.remove(x);  //OK for CopyOnWriteArrayList
                });
            }
        } catch(InterruptedException e) {
            System.out.println(this.getClass().getSimpleName() + " interrupted");
        }
        System.out.println("Final value: " + value.toString());
    }
}
