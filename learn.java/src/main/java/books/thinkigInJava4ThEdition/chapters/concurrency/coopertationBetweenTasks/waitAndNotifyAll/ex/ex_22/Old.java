package books.thinkigInJava4ThEdition.chapters.concurrency.coopertationBetweenTasks.waitAndNotifyAll.ex.ex_22;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Old {

    private volatile boolean flag = false;

    void  setFlag(){
        try {
            System.out.println("sleep() for 2000 ms");
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch(InterruptedException e) {
            System.out.println("interrupted exception in setFlag()");
        }
        flag=true;

    }

    void check(){
        while(true){
            try {
                System.out.println("Check");
                TimeUnit.MILLISECONDS.sleep(200);
                if(flag ==true){
                    System.out.println("break");
                    break;
                }
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        flag = false;

    }

    void m()  {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(this::setFlag);
        exec.execute(this::check);
        exec.shutdown();
    }

    public static void main(String[] args)  {
        new Old().m();
    }
}
