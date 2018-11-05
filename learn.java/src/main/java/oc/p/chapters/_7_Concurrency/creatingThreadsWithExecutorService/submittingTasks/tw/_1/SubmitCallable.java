package oc.p.chapters._7_Concurrency.creatingThreadsWithExecutorService.submittingTasks.tw._1;

import java.util.concurrent.*;
import java.util.stream.IntStream;

import static oc.p.chapters._7_Concurrency.creatingThreadsWithExecutorService.submittingTasks.tw._1.ExecuteRunnable.N_THREADS;

class SubmitCallable {

    static void m() {
        ExecutorService exec = null;
        try {
            exec = Executors.newScheduledThreadPool(N_THREADS);
            IntStream.rangeClosed(1, N_THREADS)
                    .mapToObj(i -> new C())
                    .map(exec::submit)
                    .mapToInt(f -> {
                        try {
                            return f.get(10, TimeUnit.SECONDS);
                        } catch (InterruptedException | ExecutionException | TimeoutException e) {
                            e.printStackTrace();
                            return -1;
                        }
                    })
                    .forEach(System.out::println);
        } finally {
            if (exec != null) {
                exec.shutdownNow();
            }
        }
    }

    public static void main(String[] args) {
        m();
    }
}
