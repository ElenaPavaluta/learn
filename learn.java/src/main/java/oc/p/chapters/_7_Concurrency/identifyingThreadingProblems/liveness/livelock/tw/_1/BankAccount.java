package oc.p.chapters._7_Concurrency.identifyingThreadingProblems.liveness.livelock.tw._1;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount {
    double balance;
    int id;
    Lock lock = new ReentrantLock();

    public BankAccount(int id, double balance) {
        this.balance = balance;
        this.id = id;
    }

    boolean withdraw(double amount) {
        if (this.lock.tryLock()) {
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
            }
            balance -= amount;
            return true;
        }
        return false;
    }

    boolean deposit(double amount) {
        if (this.lock.tryLock()) {
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
            }
            balance += amount;
            return true;
        }
        return false;
    }

    boolean tryTranfer(BankAccount dest, double amount) {
        if(this.withdraw(amount)){
            if(dest.deposit(amount)){
                return true;
            }else{
                this.deposit(amount);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        final BankAccount one = new BankAccount(1, 500d);
        final BankAccount two = new BankAccount(2, 500d);

        new Thread(new Transaction(one, two, 10d), "transaction-1").start();
        new Thread(new Transaction(two, one, 10d), "transaction-2").start();
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
        while (!source.tryTranfer(destination, amount)){
            continue;
        }
        System.out.printf("%s completed ", Thread.currentThread().getName());

    }
}

