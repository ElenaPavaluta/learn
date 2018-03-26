package books.thinkigInJava4ThEdition.chapters.concurrency.simulation.bankTellerSimulation;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

class TellerManger implements Runnable {
    private static Random random = new Random(47);
    private ExecutorService exec;
    private CustomerLine customerLine;
    private PriorityQueue<Teller> workingTellers = new PriorityQueue<>();
    private Queue<Teller> tellersDoingSomethingElse = new LinkedList<>();
    private int adjustPeriod;


    public TellerManger(ExecutorService exec, CustomerLine customerLine, int adjustPeriod) {
        this.exec = exec;
        this.customerLine = customerLine;
        this.adjustPeriod = adjustPeriod;
        Teller teller = new Teller(customerLine);
        exec.execute(teller);
        workingTellers.add(teller);
    }

    void adjustTellerNumber() {
        /**
         * This is actually a control system. By adjusting the numbers,
         * you can reveal stability issues in the control mechanism
         * If line is too long, add another teller
         */
        if(customerLine.size() / workingTellers.size() > 2) {
            /**
             * if a teller is on a break, or is doing something else, bring it back
             */
            if(tellersDoingSomethingElse.size() > 0) {
                Teller teller = tellersDoingSomethingElse.remove();
                teller.serveCustomerLine();
                workingTellers.offer(teller);
                return;
            }
            //else crate (hire) a new teller
            Teller teller = new Teller(customerLine);
            exec.execute(teller);
            workingTellers.add(teller);
            return;
        }
        //if a line is short enough, remove a teller
        if(workingTellers.size() > 1 && customerLine.size() / workingTellers.size() < 2) {
            reassingOneTeller();
        }
        //if there is no line, we only need one teller
        if(customerLine.size() == 0) {
            while(workingTellers.size() > 1) {
                reassingOneTeller();
            }
        }
    }

    private void reassingOneTeller() {
        Teller teller = workingTellers.poll();
        teller.doSomethingElse();
        tellersDoingSomethingElse.offer(teller);
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(adjustPeriod);
                adjustTellerNumber();
                System.out.print(customerLine + "{ ");
                workingTellers.forEach(t -> System.out.print(t + " "));
                System.out.print("}");
                System.out.println();
            }
        } catch(InterruptedException e) {
            System.out.println(this.getClass().getSimpleName() + " interrupted");
        }
        System.out.println(this.getClass().getSimpleName() + " terminating");
    }
}
