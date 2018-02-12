package books.thinkigInJava4ThEdition.chapters.concurrency.baiscThreading.definingTasks.tw.ex2;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Run {

    static void m() {
        Map<Integer, Integer> map = stream();
        map.forEach((k, v) -> new Thread(new T(k, v)).start());
    }

    static void m2(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        stream().forEach((k, v)->executorService.execute(new T(k, v)));
        executorService.shutdown();
    }

    static void m3(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.shutdown();
    }

    static void m4(){
        ExecutorService  executorService = Executors.newSingleThreadExecutor();
        executorService.execute(null);  //NPE
        executorService.shutdown();

    }

    private static Map<Integer, Integer> stream() {
        return Stream.iterate(1, i -> i + 1)
                .limit(5)
                .collect(Collectors.toMap(Function.identity(), i -> (int) (Math.random() * 10)));
    }

    public static void main(String[] args) {
//        m();
//        m2();
//        m3();
        m4();
    }
}
