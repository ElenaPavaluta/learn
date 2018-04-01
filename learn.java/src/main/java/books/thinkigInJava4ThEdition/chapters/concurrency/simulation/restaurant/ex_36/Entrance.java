package books.thinkigInJava4ThEdition.chapters.concurrency.simulation.restaurant.ex_36;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Entrance implements Runnable {
    private static int counter = 0;
    ArrayBlockingQueue<List<Person>> queue = new ArrayBlockingQueue<List<Person>>(10);
    private ExecutorService exec;

    private Runnable bored = () -> {
        try {
            TimeUnit.MILLISECONDS.sleep(Restaurant.rand.nextInt(1000));
            int idx = Restaurant.rand.nextInt(10);
            IntStream.rangeClosed(0, idx).forEach(i -> {
                try {
                    List<Person> list = queue.take();
                    if(i != idx) {
                        queue.put(list);
                    }
                } catch(InterruptedException e) {
                    System.out.println("bored take() interrupted");
                }
            });
        } catch(InterruptedException e) {
            System.out.println("bored interrupted");
        }
    };
    private Supplier<List<Person>> personsSupplier = () -> Stream
            .<Person>generate(() -> new Person(++counter))
            .limit(Restaurant.rand.nextInt(Restaurant.MAX_TABLE_SEATS))
            .collect(Collectors.toList());

    public Entrance(ExecutorService exec) {
        this.exec = exec;
        exec.execute(bored);
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(Restaurant.rand.nextInt(250));
                queue.put(personsSupplier.get());
            }
        } catch(InterruptedException e) {
            System.out.println(this + " interrupted");
        }
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

}
