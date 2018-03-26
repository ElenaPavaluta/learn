package books.thinkigInJava4ThEdition.chapters.concurrency.simulation.restaurant.tw;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

class Customer implements Runnable{

    private final char name;
    private final Restaurant restaurant;

    private BlockingQueue<Dish> orderedDishes = new SynchronousQueue<>();
    private StringBuilder stringBuilder = new StringBuilder();

    public Customer(char name, Restaurant restaurant) {
        this.name = name;
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
       try {
           stringBuilder.append(name).append("\n");
           Waiter waiter = restaurant.waiter();
           BusBoy busBoy = restaurant.busBoy();
           while(!Thread.interrupted()){
               for(Menu.CourseType type: Menu.CourseType.values()){
                   Dish dish = new Dish(this, waiter, new Plate(waiter.menu().randomSelect(type)));
                   stringBuilder.append(dish);
                   waiter.takeOrder(dish);
                   dish = orderedDishes.take();
                   TimeUnit.MILLISECONDS.sleep(dish.getPlate().getSingleCourse().eatTime());
                   dish.consume();
                   stringBuilder.append(dish);
                   busBoy.clean(dish);
               }
           }
       } catch(InterruptedException e) {
           e.printStackTrace();
       }
    }
}
