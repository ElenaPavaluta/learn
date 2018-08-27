package oc.p.chapters._7_Concurrency.creatingThreadsWithExecutorService.submittingTasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks)
 * throws InterruptedException;
 *
 * <T> T invokeAny(Collection<? extends Callable<T>> tasks)
 * throws InterruptedException, ExecutionException
 *
 * Both of these methods also execute synchronously. By synchronous, we mean that
 * unlike the other methods used to submit tasks to a thread executor,
 * these methods will wait until the results are available before
 * returning control to the enclosing program
 */
class SubmittingTaskCollections {

    static ExecutorService exec = Executors.newCachedThreadPool();
    static List<Callable<Integer>> lst = new ArrayList<>();

    static {
        Random r = new Random(47);
        for (int i = 0; i < 5; i++) {
            final int j = i;
            Callable<Integer> c = () -> {
                TimeUnit.MILLISECONDS.sleep(r.nextInt(100));
                return j;
            };
            lst.add(c);
        }
    }

    static void tearDown() {
        if (exec != null) {
            exec.shutdown();
        }
    }

    static void invokeAll() throws InterruptedException {
        exec.invokeAll(lst).forEach(f -> {
            try {
                System.out.println(f.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
    }

    static void invokeAny() throws ExecutionException, InterruptedException {
        System.out.println(exec.invokeAny(lst));
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        invokeAll();
        invokeAny();
    }
}
