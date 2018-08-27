package oc.p.chapters._7_Concurrency.creatingThreadsWithExecutorService.waitingForResults;

import java.util.concurrent.*;

class CheckResults {
    private static int counter = 0;

    static void m(){
        ExecutorService exec = null;
        try{
            exec = Executors.newSingleThreadExecutor();
            //here we pass a Runnable instance
            Future<?> result = exec.submit(()->{
               for(int i=0; i<500; i++) counter++;
            });
            System.out.println(result.get(10, TimeUnit.NANOSECONDS));

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }finally {
            if(exec !=null){
                exec.shutdown();
            }
        }
    }

    public static void main(String[] args) {
        m();
    }
}
