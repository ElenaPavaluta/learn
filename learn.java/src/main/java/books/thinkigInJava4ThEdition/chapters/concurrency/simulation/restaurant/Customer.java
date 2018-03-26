package books.thinkigInJava4ThEdition.chapters.concurrency.simulation.restaurant;

import java.util.concurrent.SynchronousQueue;

class Customer implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private final Waiter waiter;

    //only one course at a time can be received
    private SynchronousQueue<Plate> plateQueue = new SynchronousQueue<>();

    public Customer(Waiter waiter) {
        this.waiter = waiter;
    }

    void deliver(Plate plate) throws InterruptedException {
        //only blocks if the customer is still eating the previous course
        plateQueue.put(plate);
    }

    @Override
    public void run() {
        for(int i = 0; i < 3; i++) {
            Food food = Menu.randomSelect();
            try {
                waiter.placeOrder(this, food);
                System.out.println(this + " eating " + plateQueue.take());
            } catch(InterruptedException e) {
                System.out.println(this.getClass().getSimpleName() + " id: " + id + " interrupted");
                break;
            }
        }
        System.out.println(this + " finished meal. Leaving");
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + id;
    }
}
