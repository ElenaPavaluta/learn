package oc.p.tests.chapters._20.q._38;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Bank {

    static int cookies = 0;

    synchronized void deposit(int amount){
        cookies +=amount;
    }

    static synchronized void withdraw(int amount){
        cookies -=amount;
    }

    static void m() throws InterruptedException {
        ExecutorService exec = Executors.newScheduledThreadPool(40);
        Bank bank = new Bank();
        for(int i=0; i<25; i++){
            exec.submit(()->bank.deposit(5));
            exec.submit(()->bank.withdraw(5));
        }
        exec.shutdown();
        exec.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println(bank.cookies);
    }

    public static void main(String[] args) throws InterruptedException {
        m();
    }
}
