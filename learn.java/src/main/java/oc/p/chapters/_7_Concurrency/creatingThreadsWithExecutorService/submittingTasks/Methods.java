package oc.p.chapters._7_Concurrency.creatingThreadsWithExecutorService.submittingTasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

class Methods {
    public static final Runnable RUNNABLE = () -> System.out.println("runnable");
    public static final Callable<Integer> INTEGER_CALLABLE = () -> {
        System.out.println("Callable");
        return 007;
    };
    private static ExecutorService exec;

    static {
        exec = Executors.newSingleThreadExecutor();
    }

    static void tearDown() {
        if (exec != null) {
            exec.shutdown();
        }
    }

    static void execute() {
        exec.execute(RUNNABLE);
    }

    static void submitRunnable() throws ExecutionException, InterruptedException {
        Future<?> f = exec.submit(RUNNABLE);
        System.out.println(f);
        if (f != null) {
            System.out.println(f.get());
        }
    }

    static void submitCallable() throws ExecutionException, InterruptedException {
        Future<Integer> f = exec.submit(INTEGER_CALLABLE);
        System.out.println(f);
        if (f != null) {
            System.out.println(f.get());
        }
    }

    static void submitCallable2() throws ExecutionException, InterruptedException {
        Future<Integer> f = exec.submit(() -> {
            System.out.println("submitCallable2");
            try {
                TimeUnit.SECONDS.sleep(3);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 005;
        });
        System.out.println(f.get());
    }

    static void invokeAll() throws InterruptedException {
        Callable<Integer> c = ()->1;
        Callable<Integer> c2 = ()->2;
        Callable<Integer> c3 = ()->3;
        List<Callable<Integer>> l = new ArrayList<>();
        l.add(c);
        l.add(c2);
        l.add(c3);

        List<Future<Integer>> lf = exec.invokeAll(l);
        lf.forEach(f -> {
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
        Callable<Integer> c = ()->1;
        Callable<Integer> c2 = ()->2;
        Callable<Integer> c3 = ()->3;

        Integer lf = exec.invokeAny(Arrays.<Callable<Integer>>asList(c, c2, c3));
        System.out.println(lf);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        execute();
//        submitRunnable();
//        submitCallable();
//        submitCallable2();

//        invokeAll();
        invokeAny();

        tearDown();
    }
}
