package books.thinkigInJava._4ThEdition.chapters.concurrency.terminatingTasks.interruption.tw.p;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

class Run {

    static void m(){
        ExecutorService exec = Executors.newCachedThreadPool(new TF());
        IntStream.range(0, 10)
                 .forEach(i->exec.execute(new R(i)));
        exec.shutdownNow();
    }

    public static void main(String[] args) {
        m();
    }
}
