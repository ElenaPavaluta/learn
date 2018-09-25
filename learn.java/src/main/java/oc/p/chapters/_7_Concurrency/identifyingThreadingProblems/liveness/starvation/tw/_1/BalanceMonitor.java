package oc.p.chapters._7_Concurrency.identifyingThreadingProblems.liveness.starvation.tw._1;

class BalanceMonitor implements Runnable {
    private BankAccount account;

    public BalanceMonitor(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.format("%s Stared execution", name);
        while (true) {
            if (account.getBalance() <= 0) {
                break;
            }
        }
        System.out.format("%s : account has gone too low, email sent, exiting.", name);
    }
}


class Transaction implements Runnable{
    private BankAccount source, destination;
    private double amount;

    public Transaction(BankAccount source, BankAccount destination, double amount) {
        this.source = source;
        this.destination = destination;
        this.amount = amount;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.format("%s started execution%n", name);
        source.transfer(destination, amount);
        System.out.printf("%s completed execution%n", name);
    }
}