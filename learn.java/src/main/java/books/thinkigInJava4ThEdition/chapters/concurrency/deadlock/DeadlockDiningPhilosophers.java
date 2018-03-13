package books.thinkigInJava4ThEdition.chapters.concurrency.deadlock;

import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * Deadlock happens because each Philosopher is trying to pick up its
 * Chopsticks in a particular sequence:
 * first right, then left. Because of that, it’s possible to get
 * into a situation where each of them is holding its right Chopstick and
 * waiting to get the left, causing the circular wait condition.
 *
 * However, if the last Philosopher is initialized to try to get the
 * left chopstick first and then the right, that Philosopher will never
 * prevent the Philosopher on the immediate right from picking up their
 * its chopstick. In this case, the circular wait is prevented
 */
class DeadlockDiningPhilosophers {

    static void deadlock() throws InterruptedException {
        int ponder = 13;  //ponder = 13:deadlock
        int size = 5;

        ExecutorService exec = Executors.newCachedThreadPool();
        Chopstick[] chopsticks = new Chopstick[size];

        IntStream.range(0, size)
                .forEach(i -> chopsticks[i] = new Chopstick());

        IntStream.range(0, size)
                .forEach(i -> exec.execute(
                        new Philosopher(
                                chopsticks[i],
                                chopsticks[(i + 1) % size],
                                i,
                                ponder)));

        TimeUnit.SECONDS.sleep(7);
        exec.shutdownNow();
    }

    static void fixedDeadlock() throws InterruptedException{
        int ponder = 13;
        int size = 5;

        ExecutorService exec = Executors.newCachedThreadPool();
        Chopstick[] chopsticks = new Chopstick[size];

        IntStream.range(0, size)
                .forEach(i -> chopsticks[i] = new Chopstick());

        for(int i = 0; i<size; i++){
            if(i<size-1){
                exec.execute(new Philosopher(
                        chopsticks[i],
                        chopsticks[(i+1)%size],
                        i,
                        ponder));
            }else{
                exec.execute(new Philosopher(
                        chopsticks[0],
                        chopsticks[i],
                        i,
                        ponder));
            }
        }
        TimeUnit.SECONDS.sleep(7);
        exec.shutdownNow();
    }

    static void ex31() throws InterruptedException{
        BlockingQueue<Chopstick> queue = new LinkedBlockingQueue<>();
        int ponder = 13;
        int size = 5;

        ExecutorService exec = Executors.newCachedThreadPool();
        Chopstick[] chopsticks = new Chopstick[size];

        IntStream.range(0, size)
                .forEach(i -> chopsticks[i] = new Chopstick());

        IntStream.range(0, size)
                .forEach(i -> exec.execute(
                        new Philosopher_ex_31(
                                chopsticks[i],
                                chopsticks[(i + 1) % size],
                                i,
                                ponder,
                                queue)));

        TimeUnit.SECONDS.sleep(7);
        exec.shutdownNow();
    }

    public static void main(String[] args) throws InterruptedException {
//        deadlock();
//        fixedDeadlock();
        ex31();
    }
}