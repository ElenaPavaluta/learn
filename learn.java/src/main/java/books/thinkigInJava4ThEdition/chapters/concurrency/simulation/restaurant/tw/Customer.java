package books.thinkigInJava4ThEdition.chapters.concurrency.simulation.restaurant.tw;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

class Customer implements Runnable {

    private final char name;
    private final Restaurant restaurant;

    private BlockingQueue<Dish> orderedDishes = new SynchronousQueue<>();
    private StringBuilder stringBuilder;

    public Customer(char name, Restaurant restaurant) {
        this.name = name;
        this.restaurant = restaurant;
        stringBuilder = new StringBuilder().append(name).append("\n");

    }

    @Override
    public void run() {
        try {
            Waiter waiter = restaurant.waiter();
            BusBoy busBoy = restaurant.busBoy();
            while(!Thread.interrupted()) {
                for(Menu.CourseType type : Menu.CourseType.values()) {
                    order(waiter, type);
                    eat();
                    clean(busBoy);

                }
            }
        } catch(InterruptedException e) {
            System.out.println(this + " interrupted");
        }
        stringBuilder.append(this + " done eating");
        System.out.println(stringBuilder.toString());
    }

    private void eat() throws InterruptedException {
        Dish dish = orderedDishes.take();
        TimeUnit.MILLISECONDS.sleep(dish.getPlate().getSingleCourse().eatTime());
        dish.consume();
        stringBuilder.append(dish);
        clean();

    }


    private void order(Waiter waiter, Menu.CourseType type) {
        Dish dish = new Dish(this, waiter, new Plate(waiter.menu().randomSelect(type)));
        stringBuilder.append(dish);
        waiter.takeOrder(dish);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " name: " + name;
    }
}
