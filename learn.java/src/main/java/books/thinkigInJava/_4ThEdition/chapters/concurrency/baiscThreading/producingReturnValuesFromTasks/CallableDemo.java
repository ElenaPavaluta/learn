package books.thinkigInJava._4ThEdition.chapters.concurrency.baiscThreading.producingReturnValuesFromTasks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class CallableDemo {

    static void m(){
        ExecutorService executorService = Executors.newCachedThreadPool();

        List<Future<String>> res = new ArrayList<>();
        for(int i = 0; i<10; i++){
            res.add(executorService.submit(new TaskWithResult(i)));
        }

        for(Future<String> fs: res){
            try {
                //get() blocks until completion
                System.out.println(fs.get());
            }catch(InterruptedException e){
                System.out.println(e);
                return;
            }catch(ExecutionException e){
                System.out.println(e);
            }finally {
                executorService.shutdown();
            }
        }
    }

    public static void main(String[] args) {
        m();
    }
}
