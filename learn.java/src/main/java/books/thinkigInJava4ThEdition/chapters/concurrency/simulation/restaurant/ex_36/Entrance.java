package books.thinkigInJava4ThEdition.chapters.concurrency.simulation.restaurant.ex_36;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Entrance implements Runnable {

    private ArrayBlockingQueue<List<Person>> queue = new ArrayBlockingQueue<List<Person>>(10);

    private Supplier<List<Person>> personsSupplier = () -> Stream
            .<Person>generate(Person::new)
            .limit(Restaurant.rand.nextInt(Restaurant.MAX_TABLE_SEATS))
            .collect(Collectors.toList());


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

    List<Person> personList() {
        try {
            return queue.take();
        } catch(InterruptedException e) {
            System.out.println(this + " personList interrupted");
        }
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
