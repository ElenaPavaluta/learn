package books.thinkigInJava._4ThEdition.chapters.concurrency.terminatingTasks.theOrnamentalGarden.tw;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

class HashCode {

    class T implements Runnable{
        @Override
        public void run() {
            System.out.println("Thread: " + Thread.currentThread().getId() + " -> " + this.hashCode());
        }
    }

    static void m(){
        HashCode.T t = new HashCode(). new T();
        ExecutorService exec = Executors.newCachedThreadPool();

        IntStream.range(0,10)
                 .forEach(i->exec.execute(t));
        exec.shutdown();
    }

    static void m2(){
        ExecutorService exec = Executors.newCachedThreadPool();
        IntStream.range(0,10)
                 .forEach(i->exec.execute(new HashCode(). new T()));
        exec.shutdown();
    }

    public static void main(String[] args) {
//        createAndPopulate();
        m2();
    }
}
