package oc.p.chapters._7_Concurrency.identifyingThreadingProblems.liveness.tw._2;

import java.util.Collection;
import java.util.concurrent.*;

import static oc.p.chapters._7_Concurrency.identifyingThreadingProblems.liveness.tw._2.Deadlock.CardinalPoint.*;
import static oc.p.chapters._7_Concurrency.identifyingThreadingProblems.liveness.tw._2.Deadlock.State.*;

class Deadlock {

    static Deadlock deadlock = new Deadlock();

    static void m() {
        Deadlock.Intersection intersection = deadlock.new Intersection();

        Car c = deadlock.new Car("E_car", intersection);
        Car c2 = deadlock.new Car("W_car", intersection);
        Car c3 = deadlock.new Car("S_car", intersection);
        Car c4 = deadlock.new Car("N_car", intersection);

        intersection.arrive(c, E);
        intersection.arrive(c2, W);
        intersection.arrive(c3, S);
        intersection.arrive(c4, N);

        ExecutorService exec = Executors.newCachedThreadPool();
        try {
            intersection.cars().forEach(exec::submit);
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            if (exec != null) {
                exec.shutdown();
            }
        }
    }

    public static void main(String[] args) {
        m();
    }

    enum CardinalPoint {
        E {
            @Override
            CardinalPoint right() {
                return S;
            }
        },
        S {
            @Override
            CardinalPoint right() {
                return W;
            }
        },
        W {
            @Override
            CardinalPoint right() {
                return N;
            }
        },
        N {
            @Override
            CardinalPoint right() {
                return E;
            }
        };

        abstract CardinalPoint right();
    }

    enum State {
        BEFORE_INTERSECTION,
        INTERSECTION,
        AFTER_INTERSECTION;
    }

    class Car implements Runnable {
        private State state = BEFORE_INTERSECTION;
        private String name;
        private Intersection intersection;

        Car(final String name, final Intersection intersection) {
            this.name = name;
            this.intersection = intersection;
        }

        @Override
        public void run() {
            moveTo(INTERSECTION);
            try {
                TimeUnit.MILLISECONDS.sleep(20);
                cross(intersection);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        private void cross(final Intersection intersection) throws InterruptedException {
            synchronized (intersection) {
                printState();
                while (intersection.hasCarOnRight(this)) {
                    intersection.wait();
                }
                intersection.leave(this);
                intersection.notifyAll();
            }
            moveTo(AFTER_INTERSECTION);
            printState();
        }

        private void printState() {
            System.out.println(name + " -> " + state);
        }


        void moveTo(State end) {
            state = end;
        }

        @Override
        public boolean equals(final Object obj) {
            if (!(obj instanceof Deadlock.Car)) {
                return false;
            }
            Deadlock.Car c = (Deadlock.Car) obj;
            return this.name.equals(c.name);
        }
    }

    class Intersection {
        private ConcurrentMap <Car, CardinalPoint> map = new ConcurrentHashMap <>();

        void arrive(Car car, CardinalPoint cardinalPoint) {
            map.put(car, cardinalPoint);
        }

        Collection <Car> cars() {
            return map.keySet();
        }

        boolean hasCarOnRight(Car car) {
            CardinalPoint cardinalPoint = map.get(car).right();
            return map.values().contains(cardinalPoint);
        }

        void leave(final Car car) {
            map.remove(car);
        }
    }
}
