package oc.p.chapters._7_Concurrency.identifyingThreadingProblems.liveness.starvation;

import java.util.List;
import java.util.Set;
import java.util.concurrent.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * Starvation occurs when a single thread is perpetually denied access to a shared resource or lock.
 * The thread is still active, but it is unable to complete its work as a result of other threads
 * constantly taking the resource that they trying to access.
 */

class Starvation {
    public static final Starvation S = new Starvation();
    static Resource resource =  S.new Resource();

    class Resource{
        Set<String> set = new CopyOnWriteArraySet<>();

        synchronized void m(String s){
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                set.add(s);
            } catch (InterruptedException e) {
            }
        }

        synchronized void print(){
            System.out.println(set);
        }
    }

    class Rabbit implements Runnable{
        Resource r;

        public Rabbit(Resource r) {
            this.r = r;
        }

        @Override
        public void run() {
            while (!Thread.interrupted()){
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                    r.m(this.getClass().getSimpleName());
                } catch (InterruptedException e) {
                }
            }
        }
    }

    class Turtle implements Runnable{
        Resource r;

        public Turtle(Resource r) {
            this.r = r;
        }

        @Override
        public void run() {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                r.m(this.getClass().getSimpleName());
            } catch (InterruptedException e) {
            }
        }
    }

    class RabbitThreadFactory implements ThreadFactory{
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setPriority(Thread.MAX_PRIORITY);
            return t;
        }
    }

    class TurleThreadFactory implements ThreadFactory{
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setPriority(Thread.MIN_PRIORITY);
            return t;
        }
    }

    static void m(){
        List<Rabbit> rabbits = IntStream.range(0, 100).parallel().mapToObj(i -> S.new Rabbit(resource)).collect(toList());

        ExecutorService execR = Executors.newCachedThreadPool(S.new RabbitThreadFactory());
        rabbits.forEach(execR::submit);

        ExecutorService execT = Executors.newCachedThreadPool(S.new TurleThreadFactory());
        execT.submit(S.new Turtle(resource));

        try {
            TimeUnit.SECONDS.sleep(3);
            execR.shutdownNow();
            execT.shutdownNow();
        } catch (InterruptedException e) {

        }

        resource.print();
    }

    public static void main(String[] args) {
        m();
    }
}
