package books.thinkigInJava4ThEdition.chapters.concurrency.simulation.restaurant.ex_36;

import java.util.concurrent.SynchronousQueue;

class Customer extends Person implements Runnable {

    private final Waiter waiter;
    private final Table table;
    private SynchronousQueue<Food> plateSynchronousQueue = new SynchronousQueue<>();

    public Customer(Person person, Waiter waiter, Table table) {
        super(person.id);
        this.waiter = waiter;
        this.table = table;
    }

    void deliver(Food food) {
        try {
            plateSynchronousQueue.put(food);
        } catch(InterruptedException e) {
            System.out.println("deliver food interrupted");
        }
    }

    @Override
    public void run() {
        for(int i = 0; i < 3; i++) {
            Food food = Menu.randomSelect();
            try {
                waiter.placeOrder(this, food);
                System.out.println(this + " ordered: " + food);
                Food cooked = plateSynchronousQueue.take();
                cooked.eat();
                System.out.println(this + " eaten " + cooked);
            } catch(InterruptedException e) {
                System.out.println(this + " interrupted");
                break;
            }
        }
        waiter.leaving(this);
        System.out.println(this + " finished meal. Leaving");
    }

    public Table getTable() {
        return table;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Customer)) {
            return false;
        }
        Customer c = (Customer) obj;
        return this.id == c.id;
    }
}
