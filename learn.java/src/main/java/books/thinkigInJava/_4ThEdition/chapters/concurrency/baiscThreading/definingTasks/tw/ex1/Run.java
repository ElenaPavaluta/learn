package books.thinkigInJava._4ThEdition.chapters.concurrency.baiscThreading.definingTasks.tw.ex1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

class Run {

    static void m(){
        stream().forEach(i -> new Thread(new T(i)).start());
    }

    private static Stream<Integer> stream() {
        return Stream.iterate(1, i ->i+1)
                .limit(5);
    }

    static void m2(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        stream().forEach(i->executorService.execute(new T(i)));
        executorService.shutdown();
    }

    static void m3(){
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        stream().forEach(i->executorService.execute(new T(i)));
        executorService.shutdown();
    }

    public static void main(String[] args) {
//        m();
//        m2();
        m3();
    }
}
