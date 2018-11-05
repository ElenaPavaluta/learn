package oc.p.chapters._7_Concurrency.creatingThreadsWithExecutorService.submittingTasks.tw._1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

class ExecuteRunnable {

    public static final int N_THREADS = Runtime.getRuntime().availableProcessors();

    static void m() {
        ExecutorService exec = null;
        try {
            exec = Executors.newFixedThreadPool(N_THREADS);
            IntStream.rangeClosed(1, N_THREADS)
                    .mapToObj(i->new R())
                    .forEach(exec::execute);
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
