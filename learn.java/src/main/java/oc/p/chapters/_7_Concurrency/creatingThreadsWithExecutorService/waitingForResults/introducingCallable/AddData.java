package oc.p.chapters._7_Concurrency.creatingThreadsWithExecutorService.waitingForResults.introducingCallable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class AddData {

    static void m() throws ExecutionException, InterruptedException {
        ExecutorService exec = null;

        try {
            exec = Executors.newCachedThreadPool();
            Future<Integer> f = exec.submit(() -> 30 + 11);
            System.out.println(f.get());
        } finally {
            if (exec != null) {
                exec.shutdown();
            }
        }
    }
}
