package books.thinkigInJava4ThEdition.chapters.concurrency.coopertationBetweenTasks.usingExplicitLockAndConditionObjects.ex.ex_27;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Restaurant {
    Order order;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    ExecutorService exec = Executors.newCachedThreadPool();
    private int count;

    public static void main(String[] args) throws InterruptedException {
        new Restaurant().m();
    }

    void m() throws InterruptedException {
        exec.execute(new Waiter(this));
        exec.execute(new Chef(this));
        TimeUnit.SECONDS.sleep(3);
        exec.shutdownNow();
    }

    void prepareOrder() {
        lock.lock();
        try {
            order = new Order(++count);
            System.out.println("Prepared order: " + order);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    void deliverOrder() {
        lock.unlock();
        try {
            System.out.println("Delivered order: " + order);
            order = null;
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    void waiToPrepareOrder() throws InterruptedException {
        lock.lock();
        try {
            while(order == null) {
                condition.await();
            }
        } finally {
            lock.lock();
        }
    }

    void waitToDeliverOrder() throws InterruptedException {
        lock.lock();
        try {
            while(order != null) {
                condition.await();
            }
        } finally {
            lock.unlock();
        }
    }
}
