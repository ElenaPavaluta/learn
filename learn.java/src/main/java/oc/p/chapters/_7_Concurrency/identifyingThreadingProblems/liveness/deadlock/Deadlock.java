package oc.p.chapters._7_Concurrency.identifyingThreadingProblems.liveness.deadlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * One common strategy to avoid deadlocks is for all
 * THREADS TO ORDER THEIR RESOURCE REQUESTS.
 * For example,
 * if both foxes have a rule that they need to obtain food before water,
 * then the previous deadlock scenario will not happen again.
 * Once one of the foxes obtained food, the second fox would wait,
 * leaving the water resource available.
 */
class Deadlock {

    public static final Deadlock D = new Deadlock();
    static Fox fox = D.new Fox();
    static Fox fox2 = D.new Fox();
    static Food f = D.new Food();
    static Water w = D.new Water();

    public static void main(String[] args) {
//        deadlock();
//        fix();
        fix2();
    }

    private static void deadlock() {
        ExecutorService exec = null;
        try {
            exec = Executors.newCachedThreadPool();
            exec.submit(() -> fox.eatAndDrink(f, w));
            exec.submit(() -> fox2.drinkAndEat(f, w));
        } finally {
            if (exec != null) exec.shutdown();
        }
    }

    static void fix(){
        ExecutorService exec = null;
        try{
            exec = Executors.newCachedThreadPool();
            exec.submit(()->fox.drinkAndEat(f, w));
            exec.submit(()->fox2.drinkAndEat(f, w));
        }finally {
            if(exec !=null) exec.shutdown();
        }
    }

    static void fix2(){
        ExecutorService exec =null;
        try {
            exec = Executors.newCachedThreadPool();
            exec.submit(()->fox.eatAndDrink(f, w));
            exec.submit(()->fox2.eatAndDrink(f, w));
        }finally {
            if(exec !=null) exec.shutdown();
        }
    }

    class Food {
    }

    class Water {
    }

    class Fox {

        void eatAndDrink(Food f, Water w) {
            synchronized (f) {
                System.out.println("Got food");
                move();
                synchronized (w) {
                    System.out.println("Got water");
                }
            }
        }

        private void move() {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
            }
        }

        void drinkAndEat(Food f, Water w) {
            synchronized (w) {
                System.out.println("Got water");
                move();
                synchronized (f) {
                    System.out.println("Got food");
                }
            }
        }
    }
}
