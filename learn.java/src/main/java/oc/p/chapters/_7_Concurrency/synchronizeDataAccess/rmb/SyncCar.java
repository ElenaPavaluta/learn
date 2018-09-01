package oc.p.chapters._7_Concurrency.synchronizeDataAccess.rmb;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

class SyncCar {

    static void m() throws InterruptedException {
        Car car = new Car();
        final int corePoolSize = Runtime.getRuntime().availableProcessors() * 5;
        ExecutorService exec = Executors.newScheduledThreadPool(corePoolSize);
        IntStream.range(0, corePoolSize)
                .mapToObj(i -> {
                    if (i % 2 == 0) {
                        return new WaxOn(car);
                    }
                    return new WaxOff(car);
                })
                .forEach(r -> exec.submit(r));
        TimeUnit.SECONDS.sleep(7);
        exec.shutdownNow().stream().forEach(System.out::println);
    }

    public static void main(String[] args) throws InterruptedException {
        m();
    }
}

class Car {
    private boolean waxing = false;

    synchronized void waxOn() throws InterruptedException {
        waxing = true;
        System.out.println(Thread.currentThread().getId() + " wax on");
        TimeUnit.MILLISECONDS.sleep(500);
        notifyAll();
    }

    synchronized void waxOff() throws InterruptedException {
        waxing = false;
        System.out.println(Thread.currentThread().getId() + " Wax off");
        TimeUnit.MILLISECONDS.sleep(500);
        notifyAll();
    }

    synchronized void waitingForWaxOn() throws InterruptedException {
        while (waxing == false) {
            wait();
        }
    }

    synchronized void waitingForWaxOff() throws InterruptedException {
        while (waxing) {
            wait();
        }
    }
}

class WaxOn implements Runnable {
    private Car car;

    WaxOn(final Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                car.waxOn();
                car.waitingForWaxOff();
            } catch (InterruptedException e) {
                System.out.println("Exit via interrupt");
            }
        }
        System.out.println("Exit");
    }
}

class WaxOff implements Runnable {
    private Car car;

    WaxOff(final Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                car.waitingForWaxOn();
                car.waxOff();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

