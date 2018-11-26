package oc.p.chapters._7_Concurrency.identifyingThreadingProblems.liveness.tw._1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Deadlock {

    static Deadlock d = new Deadlock();
    static Food f = new Food();
    static Water w = new Water();
    static Fox fox = d.new Fox();
    static Fox fox2 = d.new Fox();
    static ExecutorService exec = null;

    static void deadlock() {
        try {
            exec = Executors.newFixedThreadPool(2);
            exec.submit(() -> fox.drinkAndEat(f, w));
            exec.submit(() -> fox2.eatAndDrink(f, w));
        } finally {
            if (exec != null) {
                exec.shutdownNow();
            }
        }
    }

    public static void main(String[] args) {
        deadlock();
    }

    class Fox {

        void eatAndDrink(Food f, Water w) {
            synchronized (f) {
                System.out.println("Food");
                move();
                synchronized (w) {
                    System.out.println("Water");
                }
            }
        }

        void drinkAndEat(Food f, Water w) {
            synchronized (w) {
                System.out.println("Water");
                move();
                synchronized (f) {
                    System.out.println("food");
                }
            }
        }

        private void move() {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
//                e.printStackTrace();
            }
        }
    }

    static class Food {
    }

    static class Water {
    }
}
