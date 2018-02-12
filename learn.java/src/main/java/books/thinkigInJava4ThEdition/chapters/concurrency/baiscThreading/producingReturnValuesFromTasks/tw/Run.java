package books.thinkigInJava4ThEdition.chapters.concurrency.baiscThreading.producingReturnValuesFromTasks.tw;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Run
{
    class R implements Runnable{
        @Override
        public void run() {
            System.out.println("Run.R");
        }
    }

    static void m(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Run(). new R());
        executorService.shutdown();
    }

    static void m2() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<?> f = executorService.submit(new Run(). new R());
        System.out.println(f.getClass());
        if(f.get() == null){
            System.out.println("null");
        }

//        System.out.println(f.get().toString());
        executorService.shutdown();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        m();
        m2();
    }

}
