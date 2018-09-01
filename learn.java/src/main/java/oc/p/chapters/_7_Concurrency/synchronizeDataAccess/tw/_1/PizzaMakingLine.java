package oc.p.chapters._7_Concurrency.synchronizeDataAccess.tw._1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static oc.p.chapters._7_Concurrency.synchronizeDataAccess.tw._1.PizzaMakingLine.PizzaState.*;

class PizzaMakingLine {

    private Pizza p = new Pizza();

    Runnable one = () -> p.one();
    Runnable two = () -> p.two();
    Runnable three = () -> p.three();
    Runnable four = () -> p.four();
    Runnable clear = () -> p.clear();

    public static void main(String[] args) {
        PizzaMakingLine line = new PizzaMakingLine();
        line.m();
    }

    void m() {
        ExecutorService exec = null;
        try {
            exec = Executors.newFixedThreadPool(5);
            exec.submit(clear);
            exec.submit(four);
            exec.submit(three);
            exec.submit(two);
            exec.submit(one);
            exec.submit(clear);
            exec.submit(four);
            exec.submit(three);
            exec.submit(two);
            exec.submit(one);
            TimeUnit.SECONDS.sleep(7);
        } catch (InterruptedException e) {
            System.out.println("interrupt");
        } finally {
            if (exec != null) {
                exec.shutdownNow();
            }
        }
    }

    enum PizzaState {
        One,
        Two,
        Three,
        Four;
    }

    class Pizza {
        private PizzaState state = null;

        synchronized void one() {
            m(null, One);
        }

        synchronized void two() {
            m(One, Two);
        }

        synchronized void three() {
            m(Two, Three);
        }

        synchronized void four() {
            m(Three, Four);
        }

        synchronized void clear() {
            m(Four, null);
        }

        private synchronized void m(PizzaState waitSate, PizzaState newState) {
            while (!Thread.interrupted()) {
                wait(waitSate);
                change(waitSate, newState);
            }
        }

        private void change(final PizzaState waitSate, final PizzaState newState) {
            try {
                System.out.println(Thread.currentThread().getId() + ": " + waitSate + " -> " + newState);
                TimeUnit.MILLISECONDS.sleep(500);
                state = newState;
                notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void wait(final PizzaState waitSate) {
            while (state != waitSate) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("Exit via interrupt");
                }
            }
        }

    }

}

