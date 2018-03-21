package books.thinkigInJava4ThEdition.chapters.concurrency.newLibraryComponents.exchanger;

import java.util.List;
import java.util.concurrent.*;
import java.util.function.Supplier;

class Demo {

    static final int SIZE = 10;
    static int delay = 5;  //Seconds

    void m() {
        try {
            ExecutorService exec = Executors.newCachedThreadPool();

            Exchanger<List<Expensive>> exchanger = new Exchanger<>();

            List<Expensive> producerList = new CopyOnWriteArrayList<>();
            List<Expensive> consumerList = new CopyOnWriteArrayList<>();

            Supplier<Expensive> supplier = Expensive::new;

            exec.execute(new ExchangeProducer<Expensive>(supplier, exchanger, producerList));
            exec.execute(new ExchangerConsumer<Expensive>(exchanger, consumerList));

            TimeUnit.SECONDS.sleep(delay);
            System.out.println("calling shutdownNow()");
            exec.shutdownNow();

            System.out.println("called shutdownNow()");
        } catch(InterruptedException e) {
            System.out.println(this.getClass().getSimpleName() + " interupted");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Demo().m();
    }


}
