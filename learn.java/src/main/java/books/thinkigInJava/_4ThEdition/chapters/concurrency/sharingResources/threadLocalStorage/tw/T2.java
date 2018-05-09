package books.thinkigInJava._4ThEdition.chapters.concurrency.sharingResources.threadLocalStorage.tw;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

class T2 extends Thread{

    static ThreadLocal<String> local = new ThreadLocal<>();

    @Override
    public void run() {
        local.set(String.valueOf(Thread.currentThread().getId()));
        System.out.println(local.get());
    }

    static void m(){
        ExecutorService exec = Executors.newCachedThreadPool();
        IntStream.range(0,10)
                 .forEach(i->exec.execute(new T2()));
        exec.shutdown();  //the shutdown() method doesn't terminate the submitted task, as opposite to shutdownNow()
    }

    public static void main(String[] args) {
        m();
    }
}
