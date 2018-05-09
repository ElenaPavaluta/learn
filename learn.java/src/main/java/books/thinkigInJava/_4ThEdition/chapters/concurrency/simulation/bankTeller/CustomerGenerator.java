package books.thinkigInJava._4ThEdition.chapters.concurrency.simulation.bankTeller;

import java.util.Random;
import java.util.concurrent.TimeUnit;

class CustomerGenerator implements Runnable{
    private CustomerLine customers;
    private static Random  rand = new Random(47);


    public CustomerGenerator(CustomerLine customers) {
        this.customers = customers;
    }

    @Override
    public void run() {
        try{
            while(!Thread.interrupted()){
                TimeUnit.MILLISECONDS.sleep(rand.nextInt(300));
                customers.put(new Customer(rand.nextInt(1000)));
            }
        }catch(InterruptedException e){
            System.out.println(this.getClass().getSimpleName() + " interrupted");
        }
        System.out.println(this.getClass().getSimpleName() + " terminated");
    }
}
