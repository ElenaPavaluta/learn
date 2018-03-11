package books.thinkigInJava4ThEdition.chapters.concurrency.coopertationBetweenTasks.usingExplicitLockAndConditionObjects;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Car {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean waxOn = false;

    void waxed(){
        lock.lock();
        try {
            waxOn = true;  //ready to buff
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    void buffed(){
        lock.lock();
        try {
            waxOn = false;  //ready for another coat of wax
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    void waitingForWaxing() throws InterruptedException{
       lock.lock();
       try{
           while(waxOn == false){
               condition.await();
           }
       }finally {
           lock.unlock();
       }
    }

    void waitingForBuffing() throws InterruptedException{
        lock.lock();
        try{
            while(waxOn == true){
                condition.await();
            }
        }finally {
            lock.unlock();
        }
    }
}
