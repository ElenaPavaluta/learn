package books.thinkigInJava4ThEdition.chapters.concurrency.baiscThreading.producingReturnValuesFromTasks.ex5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Function;

class T implements Callable<Integer> {

    static Function<Future<Integer>, Integer> fi = new Function<Future<Integer>, Integer>() {
        @Override
        public Integer apply(Future<Integer> integerFuture) {
            try {

                return integerFuture.get();
            } catch(InterruptedException | ExecutionException e) {
                return -1;
            }
        }
    };
    private int n;

    T(int n) {
        this.n = n;
    }

    static void m() {
        ExecutorService executors = Executors.newCachedThreadPool();
        List<Future<Integer>> lst = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            lst.add(executors.submit(new T((int) (Math.random() * 10))));
        }
        lst.stream().map(fi).forEach(System.out::println);
    }

    public static void main(String[] args) {
        m();
    }

    List<Integer> fibonacci() {
        List<Integer> lst = new ArrayList<>();
        lst.add(0);
        lst.add(1);
        for(int i = 2; i < n; i++) {
            lst.add(lst.get(i - 1).intValue() + lst.get(i - 2).intValue());
        }
        return lst;
    }

    @Override
    public Integer call() {
        return fibonacci().stream().mapToInt(Integer::intValue).sum();
    }
}
