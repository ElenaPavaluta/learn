package books.thinkigInJava4ThEdition.chapters.concurrency.sharingResources.threadLocalStorage.tw;

import org.omg.PortableInterceptor.INACTIVE;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

class T implements Runnable{

    /**
     * CANNOT USE ''<>'' WITH ANONYMOUS INNER CLASSES
     *
     * new ThreadLocal<Integer>
     *
     */
     ThreadLocal<Integer> local  =new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            System.out.println();
            System.out.println(Thread.currentThread().getId());
            long l = Thread.currentThread().getId();
            Thread.yield();
            System.out.println(Thread.currentThread().getId());
            System.out.println();
            return new Integer((int)l);
        }
    };

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getId() + "-> " +local.get());
    }

    static void m(){
        ExecutorService exec = Executors.newCachedThreadPool();
        IntStream.range(0,10)
                 .forEach(i->exec.execute(new T()));
        exec.shutdown();
    }

    public static void main(String[] args) {
        m();
    }
}
