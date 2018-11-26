package oc.p.chapters._7_Concurrency.identifyingThreadingProblems.liveness.tw._1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class Livelock {

    public static void main(String[] args) {
        m();
    }

    static void m(){
        Livelock.BankAccount a = new Livelock().new BankAccount(1, 500);
        Livelock.BankAccount b = new Livelock().new BankAccount(2, 500);

        Livelock.Transaction t = new Livelock().new Transaction("t -> t2", a, b, 100);
        Livelock.Transaction t2 = new Livelock().new Transaction("t2 -> t", b, a, 100);

        ExecutorService exec = null;

        try {
            exec = Executors.newFixedThreadPool(2);
            exec.submit(t);
            exec.submit(t2);
        }finally {
            if (exec!=null){
                exec.shutdown();
            }
        }
    }

    class BankAccount{
        int id;
        double amount;
        ReentrantLock lock;

        BankAccount(final int id, final double amount) {
            this.id = id;
            this.amount = amount;
            lock = new ReentrantLock();
        }

        boolean deposit(double amount){
            if(lock.tryLock()){
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                }
                this.amount += amount;
                return true;
            }
            return false;
        }

        boolean withdraw(double amount){
            if(lock.tryLock()){
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.amount -= amount;
                return true;
            }
            return false;
        }

        boolean transferTo(Livelock.BankAccount ba, double amount){
            if(this.withdraw(amount)){
                if(ba.deposit(amount)){
                    return true;
                }else {
                    this.deposit(amount);
                }
            }
            return false;
        }
    }

    class Transaction implements Runnable{
        String name;
        Livelock.BankAccount source;
        Livelock.BankAccount destination;
        double amount;

        Transaction(final String name, final BankAccount source, final BankAccount destination, final double amount) {
            this.name = name;
            this.source = source;
            this.destination = destination;
            this.amount = amount;
        }

        @Override
        public void run() {
            System.out.println(name);
            while (!source.transferTo(destination, amount)){
                try {
                    TimeUnit.MILLISECONDS.sleep(200);
                } catch (InterruptedException e) {
                }
            }
            System.out.println(name + " done");
        }
    }
}
