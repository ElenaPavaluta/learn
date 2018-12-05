package oc.p.tests.chapters._20.q._27;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Accountant {
    static void completePaperwork() {
        System.out.print("[Filling]");
    }

    static double getPi() {
        return 3.141459;
    }

    static void m() throws ExecutionException, InterruptedException {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        Future <?> f = exec.submit(() -> completePaperwork());
        Future <Object> f2 = exec.submit(() -> getPi());

        System.out.println(f.get() + " " + f2.get());
        exec.shutdown();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        m();
    }
}
