package oc.p.chapters._7_Concurrency.synchronizeDataAccess.tw._3;

import utils.print.Print;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

class Run {

    static int MAX = 5;

    static void m() {
        ConcurrentSkipListMap <Integer, CopyOnWriteArrayList <Pair>> map = new ConcurrentSkipListMap <>();

        final List <Order> orders = IntStream.rangeClosed(1, 5)
                .mapToObj(i -> new Order(i, map))
                .collect(toList());

        final List <Runnable> runnables = IntStream.rangeClosed(1, 30)
                .mapToObj(i -> {
                    switch (i % 3) {
                        case 0:
                            return new Three(orders.get(i % 5));
                        case 1:
                            return new Two(orders.get(i % 5));
                        case 2:
                            return new One(orders.get(i % 5));
                        default:
                            return null;
                    }
                })
                .collect(toList());

        ExecutorService exec = null;
        try {
            exec = Executors.newCachedThreadPool();
            runnables.forEach(exec::submit);
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (exec != null) {
                exec.shutdown();
            }
        }

        Print.print(map);
    }

    public static void main(String[] args) {
        m();
    }
}


class One implements Runnable {
    Order o;

    One(final Order o) {
        this.o = o;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                o.one();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Two implements Runnable {
    Order o;

    Two(final Order o) {
        this.o = o;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                o.two();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Three implements Runnable {
    Order o;

    Three(final Order o) {
        this.o = o;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                o.third();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}