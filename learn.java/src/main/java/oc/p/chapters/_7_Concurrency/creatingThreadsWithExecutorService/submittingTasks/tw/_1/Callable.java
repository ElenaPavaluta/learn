package oc.p.chapters._7_Concurrency.creatingThreadsWithExecutorService.submittingTasks.tw._1;

import java.util.concurrent.*;

class Callable {

    static ExecutorService exec = Executors.newCachedThreadPool();
    static void tearDown(){
        if(exec !=null){
            exec.shutdown();
        }
    }

    static void m() throws ExecutionException, InterruptedException {
        Future<Integer> f = exec.submit(()->{
            TimeUnit.SECONDS.sleep(3);
            return 1;
        });
        System.out.println(f.get());  //waits until the value is available
        System.out.println("m()");
    }

    static void m2() throws ExecutionException, InterruptedException {
        Future<Integer> f = exec.submit(()->{
            TimeUnit.SECONDS.sleep(3);
            return 1;
        });
        System.out.println("m()");
        System.out.println(f.get());
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        m();
        m2();

        tearDown();
    }
}
