package oc.p.chapters._7_Concurrency.creatingThreadsWithExecutorService.shuttingDownAThreadExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

class ShutdownVsShutdownNow {

    static void exec(ExecutorService exec) {
        IntStream.range(0, 10).forEach(i -> {
            exec.execute(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
//                    e.printStackTrace();
                }
            });
        });
    }

    static void shutdown() {
        ExecutorService exec = null;
        try {
            exec = Executors.newSingleThreadExecutor();
            exec(exec);
        } finally {
            if (exec != null) exec.shutdown();
            System.out.println(exec.isShutdown());
            System.out.println(exec.isTerminated());
        }
    }

    static void shutdownNow() {
        ExecutorService exec = null;
        try {
            exec = Executors.newSingleThreadExecutor();
            exec(exec);
        } finally {
            if (exec != null) exec.shutdownNow().forEach(r -> System.out.println(r.hashCode()));
            System.out.println(exec.isShutdown());
            System.out.println(exec.isTerminated());
        }
    }

    public static void main(String[] args) {
//        shutdown();
        shutdownNow();
    }
}
