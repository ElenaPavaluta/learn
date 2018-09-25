package oc.p.chapters._7_Concurrency.identifyingThreadingProblems.liveness.starvation.tw._1;

class Run {
    static void m(){
        final BankAccount one = new BankAccount(500d, 1);
        final BankAccount two    = new BankAccount(500d, 2);

        Thread balanceMonitorThread1 = new Thread(new BalanceMonitor(one), "BalanceMonitor");
        Thread transactionThread1 = new Thread(new Transaction(one, two, 250d), "Transaction-1");
        Thread transactionThread2 = new Thread(new Transaction(one, two, 250d), "Transaction-2");

        balanceMonitorThread1.setPriority(Thread.MAX_PRIORITY);
        transactionThread1.setPriority(Thread.MIN_PRIORITY);
        transactionThread2.setPriority(Thread.MIN_PRIORITY);

        // Start the monitor
        balanceMonitorThread1.start();

        // And later, transaction threads tries to execute.
        try {Thread.sleep(100l);} catch (InterruptedException e) {}
        transactionThread1.start();
        transactionThread2.start();
    }

    public static void main(String[] args) {
        m();
    }
}
