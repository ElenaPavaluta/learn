package oc.p.tests.chapters._20.q._15;

import java.util.concurrent.*;

class Q {

    static void m() throws ExecutionException, InterruptedException {
        Callable c = new Callable() {
            @Override
            public Object call() throws Exception {
                return 10;
            }
        };

        ExecutorService s = Executors.newScheduledThreadPool(1);
        for(int i = 0; i>10; i++){
            Future f = s.submit(c);
            f.get();
        }
        s.shutdown();
        System.out.println("Done");
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        m();
    }
}
