package oc.p.chapters._7_Concurrency.synchronizeDataAccess.tw._2;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

class Run {

    static void m() {
        Carrier c = new Carrier();
        ExecutorService exec = null;
        try {
            exec = Executors.newCachedThreadPool();
            IntStream.rangeClosed(1, 20)
                    .mapToObj(i -> i % 2 == 0 ? new Add$(c) : new Add_(c))
                    .collect(toList())
                    .forEach(exec::execute);
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (exec != null) {
                exec.shutdown();
            }
        }
        System.out.println(c.queue);
    }

    public static void main(String[] args) {
        m();
    }
}

class Carrier {
    static int MAX = 10;
    Queue <String> queue = new ConcurrentLinkedQueue <>();

    private boolean add$ = true;


    synchronized void add$() throws InterruptedException {
        while (!add$) {
            wait();
        }
        queue.add("$");
        add$ = false;
        notifyAll();
    }

    synchronized void add_() throws InterruptedException {
        while (add$) {
            wait();
        }
        queue.add("_");
        add$ = true;
        notifyAll();
    }
}

class Add$ implements Runnable {
    Carrier c;

    Add$(final Carrier c) {
        this.c = c;
    }

    @Override
    public void run() {
        for (int i = 0; i < Carrier.MAX; i++) {
            try {
                c.add$();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Add_ implements Runnable {
    Carrier c;

    Add_(final Carrier c) {
        this.c = c;
    }

    @Override
    public void run() {
        for (int i = 0; i < Carrier.MAX; i++) {
            try {
                c.add_();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}