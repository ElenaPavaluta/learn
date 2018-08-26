package oc.p.chapters._7_Concurrency.creatingThreadsWithExecutorService.introducingTheSingleThreadExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ZooInfo {

    static void m() {
        ExecutorService executorService = null;

        try {
            executorService = Executors.newSingleThreadExecutor();
            System.out.println("begin");
            executorService.execute(() -> System.out.println("printing zoo inventory"));
            executorService.execute(() -> {
                for (int i = 0; i < 3; i++)
                    System.out.println("Rec: " + i);
            });
            executorService.execute(() -> System.out.println("Printing zoo inventory"));
            System.out.println("end");

        } finally {
            if (executorService != null) {
                executorService.shutdown();
            }
        }

    }

    public static void main(String[] args) {
        m();
    }
}
