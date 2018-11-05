package oc.p.chapters._7_Concurrency.creatingThreadsWithExecutorService.submittingTasks.tw._2;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

class SynchronVsAsynchron {

    static void m() throws InterruptedException, ExecutionException {
        ExecutorService exec = null;
        try {
            exec = Executors.newCachedThreadPool();

            System.out.println("0");
            exec.execute(new R());
            System.out.println("execute is asynchronous");

            exec.submit(new R());
            System.out.println("submit R is asynchronous");

            exec.submit(new C());
            System.out.println("submit C is asynchronous");

            List <C> list = IntStream.rangeClosed(1, 10)
                    .mapToObj(i -> new C())
                    .collect(toList());

//            exec.invokeAll(list);
            exec.invokeAny(list);
            System.out.println("invokeAll/ in synchronous");

        } finally {
            if (exec != null) exec.shutdownNow();
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        m();
    }
}
