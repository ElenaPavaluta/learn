package oc.p.tests.chapters._20.q._7;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Q {

    static void m() throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        Future bosses = service.submit(()-> System.out.println());
        service.shutdown();

        System.out.println(bosses.get());
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        m();
    }
}
