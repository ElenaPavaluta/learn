package books.thinkigInJava._4ThEdition.chapters.concurrency.newLibraryComponents.countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class CountDownLatchDemo {

    static final int SIZE = 100;

    static void m(){
        ExecutorService exec = Executors.newCachedThreadPool();
        //All must share a single CountDownLatch object
        CountDownLatch latch = new CountDownLatch(SIZE);

        for(int i=0; i<10; i++){
            exec.execute(new WaitingTask(latch));
        }

        for(int  i =0; i<SIZE; i++){
            exec.execute(new TaskPortion(latch));
        }
        System.out.println("Launched all");
        exec.shutdown();
    }

    public static void main(String[] args) {
        m();
    }
}
