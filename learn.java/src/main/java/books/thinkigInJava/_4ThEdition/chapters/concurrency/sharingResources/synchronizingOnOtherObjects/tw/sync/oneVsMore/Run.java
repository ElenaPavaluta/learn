package books.thinkigInJava._4ThEdition.chapters.concurrency.sharingResources.synchronizingOnOtherObjects.tw.sync.oneVsMore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

class Run {

    static void m(){
        ExecutorService exec = Executors.newCachedThreadPool();
        R r = new R();
        IntStream.range(0, 10)
                .forEach(i -> exec.execute(r));
        exec.shutdown();
    }

    static void m2(){
        ExecutorService exec = Executors.newCachedThreadPool();
        IntStream.range(0, 10)
                 .forEach(i-> exec.execute(new R()));
        exec.shutdown();
    }

    public static void main(String[] args) {
        m();
//        m2();
    }
}
