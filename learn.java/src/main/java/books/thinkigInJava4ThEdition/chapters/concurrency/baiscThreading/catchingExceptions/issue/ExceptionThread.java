package books.thinkigInJava4ThEdition.chapters.concurrency.baiscThreading.catchingExceptions.issue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ExceptionThread implements Runnable{

    @Override
    public void run() {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
//        m();
        m2();
    }

    static void m2(){
        try {
            ExecutorService exec = Executors.newCachedThreadPool();
            exec.execute(new ExceptionThread());
        }catch(RuntimeException re){
            //This statement will not be executed
            System.out.println("Exception has been handled");
        }
    }

    static void m() {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ExceptionThread());
    }
}
