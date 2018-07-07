package books.thinkigInJava._4ThEdition.chapters.concurrency.baiscThreading.usingExecutors;

import books.thinkigInJava._4ThEdition.chapters.concurrency.baiscThreading.definingTasks.LiftOff;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * An ExecutorService is a Executor with a service lifecycle
 *
 *
 * With the FixedThreadPool, you do expensive thread allocation once,
 * up front, and you thus limit the number of threads.
 * This saves time because you aren’t constantly paying for thread creation
 * overhead for every single task.
 * Also, in an event-driven system, event handlers that require threads can be
 * serviced as quickly as you want by simply fetching threads from the pool.
 * You don’t overrun the available resources because the FixedThreadPool uses a
 * bounded number of Thread objects
 *
 *
 * Run tasks with SingleThreadExecutor to ensure that only one task
 * at a time is running from any thread
 */
class CachedThreadPool {

    static void m() {
        ExecutorService executors = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++) {
            executors.execute(new LiftOff(i));
        }

        /**
         * Prevents new tasks from being submitted to that Executor
         *
         * The current thread (in this case, the one driving main()) will
         * continue to run all tasks submitted before shutdown was called
         */
        executors.shutdown();
        ;
    }

    static void m2() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++) {
            executorService.execute(new LiftOff(i));
        }
        executorService.shutdown();
//        executorService.execute(new LiftOff(11));  //RE: RejectedExecutionException
    }

    static void m3() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for(int i = 0; i < 10; i++) {
            executorService.execute(new LiftOff(i));
        }
        executorService.shutdown();
    }

    static void m4() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.execute(() -> System.out.println("A"));
        executorService.execute(() -> System.out.println("B"));
        executorService.execute(() -> System.out.println("C"));

        executorService.shutdown();
    }

    static void m5() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for(int i = 0; i < 5; i++) {
            executorService.execute(new LiftOff());
        }
        executorService.shutdown();
    }

    static void m6() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> System.out.println("A"));
        executorService.execute(() -> System.out.println("B"));
        executorService.execute(() -> System.out.println("C"));
        executorService.execute(() -> System.out.println("D"));
        executorService.execute(() -> System.out.println("E"));
        executorService.shutdown();
    }

    public static void main(String[] args) {
//        createAndPopulate();
//        m2();
//        m3();
//        m4();
        m5();
    }
}
