package books.thinkigInJava4ThEdition.chapters.concurrency.simulation.bankTellerSimulation;

import java.util.concurrent.TimeUnit;

class Teller implements Runnable, Comparable<Teller> {
    private static int counter = 0;
    private final int id = counter++;

    private int customerServed = 0;
    private CustomerLine customers;
    private boolean servingCustomerLine = true;

    public Teller(CustomerLine customers) {
        this.customers = customers;
    }

    @Override
    public synchronized int compareTo(Teller o) {
        return Integer.compare(customerServed, o.customerServed);
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                Customer customer = customers.take();
                TimeUnit.MILLISECONDS.sleep(customer.getServiceTime());
                synchronized(this) {
                    customerServed++;
                    while(!servingCustomerLine) {
                        wait();
                    }
                }
            }
        } catch(InterruptedException e) {
            System.out.println(this.getClass().getSimpleName() + " interrupted");
        }
        System.out.println(this.getClass().getSimpleName() + " terminating");
    }

    synchronized void doSomethingElse() {
        customerServed = 0;
        servingCustomerLine = false;
    }

    synchronized void serveCustomerLine() {
        servingCustomerLine = true;
        notifyAll();
    }

    @Override
    public String toString() {
        return "Teller " + id + " ";
    }

}
