package books.thinkigInJava4ThEdition.chapters.concurrency.simulation.bankTeller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Simulation {

    static final int MAX_LINE = 50;
    static final int ADJUST_PERIOD = 1000;

    static void m() throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        //if line is too long the customer will leave
        CustomerLine customerLine = new CustomerLine(MAX_LINE);

        exec.execute(new CustomerGenerator(customerLine));
        exec.execute(new TellerManger(exec, customerLine, ADJUST_PERIOD));

        TimeUnit.SECONDS.sleep(10);

        exec.shutdownNow();
    }

    public static void main(String[] args) throws InterruptedException {
        m();
    }
}
