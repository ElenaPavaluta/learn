package oc.p.chapters._7_Concurrency.creatingThreadsWithExecutorService.shuttingDownAThreadExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Once you have finished using a thread executor,
 * it is important that you call the shutdown() method.
 *
 * A thread executor creates a non-daemon thread on the first task that is executed,
 * so failing to call shutdown() will result in your application never terminating.
 *
 * The ExecutorService interface does not implement AutoCloseable,
 * so you cannot use a try-with-resources statement.
 *
 * One can still use a finally block.
 * While not required, it is considered a good practice to do so.
 */
class Info {

    static void m() {
        ExecutorService exec = null;

        try {
            exec = Executors.newSingleThreadExecutor();
            exec.execute(() -> System.out.println("exec"));
        } finally {
            if (exec != null) {
                exec.shutdown();
            }
        }
    }
}
