package oc.p.chapters._7_Concurrency.creatingThreadsWithExecutorService.submittingTasks.tw._1;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static oc.p.chapters._7_Concurrency.creatingThreadsWithExecutorService.submittingTasks.tw._1.ExecuteRunnable.N_THREADS;

class InvokeAll {

    static void m() {
        ExecutorService exec = null;
        try {
            exec = Executors.newFixedThreadPool(N_THREADS);
            List <C> collect = IntStream.rangeClosed(1, N_THREADS)
                    .mapToObj(i -> new C())
                    .collect(toList());
            try {
                exec.invokeAll(collect).forEach(f -> {
                    if (f.isDone()) {
                        try {
                            System.out.println(f.get());
                        } catch (InterruptedException | ExecutionException e) {
                            e.printStackTrace();
                        }
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            if (exec != null) exec.shutdownNow();
        }
    }

    public static void main(String[] args) {
        m();
    }
}
