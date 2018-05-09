package books.thinkigInJava._4ThEdition.chapters.concurrency.newLibraryComponents.exchanger;

import java.util.List;
import java.util.concurrent.Exchanger;
import java.util.function.Supplier;
import java.util.stream.IntStream;

class ExchangeProducer<T> implements Runnable {

    private Supplier<T> supplier;
    private Exchanger<List<T>> exchanger;
    private List<T> holder;

    public ExchangeProducer(Supplier<T> supplier, Exchanger<List<T>> exchanger, List<T> holder) {
        this.supplier = supplier;
        this.exchanger = exchanger;
        this.holder = holder;
    }

    @Override
    public void run() {
        while(!Thread.interrupted()) {
            IntStream.range(0, Demo.SIZE)
                     .forEach(i -> holder.add(supplier.get()));
            try {
                holder = exchanger.exchange(holder);
            } catch(InterruptedException e) {
                System.out.println(this.getClass().getSimpleName() + " interrupted");
            }

        }

    }
}
