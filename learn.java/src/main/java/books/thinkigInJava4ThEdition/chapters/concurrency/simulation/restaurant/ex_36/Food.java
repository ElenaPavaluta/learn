package books.thinkigInJava4ThEdition.chapters.concurrency.simulation.restaurant.ex_36;
import java.util.concurrent.TimeUnit;

import static books.thinkigInJava4ThEdition.chapters.concurrency.simulation.restaurant.ex_36.Food.Status.*;
class Food {

    private String item;
    private Status status;

    public Food(String item) {
        this.item = item;
        status = NEW;
    }

    public String getItem() {
        return item;
    }

    @Override
    public String toString() {
        return item;
    }

    void cook() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(Restaurant.rand.nextInt(200));
        status = COOKED;
    }

    void eat() throws InterruptedException{
        TimeUnit.MILLISECONDS.sleep(Restaurant.rand.nextInt(200));
        status = EATEN;
    }

    boolean isCooked(){
        return status.equals(COOKED);
    }

    enum Status{
        NEW,
        COOKED,
        EATEN;
    }
}
