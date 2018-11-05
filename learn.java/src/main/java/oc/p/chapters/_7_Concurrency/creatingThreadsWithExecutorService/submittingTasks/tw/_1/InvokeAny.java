package oc.p.chapters._7_Concurrency.creatingThreadsWithExecutorService.submittingTasks.tw._1;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static oc.p.chapters._7_Concurrency.creatingThreadsWithExecutorService.submittingTasks.tw._1.ExecuteRunnable.N_THREADS;

class InvokeAny {

    static void m() {
        ExecutorService exec = null;
        try {
            exec = Executors.newScheduledThreadPool(N_THREADS);
            List <C> list = IntStream.rangeClosed(1, N_THREADS)
                    .mapToObj(i -> new C())
                    .collect(toList());
            try {
                Integer integer = exec.invokeAny(list);
                System.out.println(integer);
            } catch (InterruptedException | ExecutionException e) {
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
