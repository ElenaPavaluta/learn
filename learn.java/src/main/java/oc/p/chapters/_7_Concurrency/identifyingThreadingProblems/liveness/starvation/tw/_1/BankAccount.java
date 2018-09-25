package oc.p.chapters._7_Concurrency.identifyingThreadingProblems.liveness.starvation.tw._1;

import java.util.concurrent.TimeUnit;

class BankAccount {
    double balance;
    int id;

    public BankAccount(double balance, int id) {
        this.balance = balance;
        this.id = id;
    }

    synchronized double getBalance() {
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
        }
        return balance;
    }

    synchronized void withdraw(double amount){
        balance -=amount;
    }

    synchronized void deposit(double amount){
        balance +=amount;
    }

    synchronized void transfer(BankAccount to, double amount){
        withdraw(amount);
        to.deposit(amount);
    }
}

