package oc.p.chapters._7_Concurrency.creatingThreadsWithExecutorService.waitingForResults.introducingCallable;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.function.Supplier;

/**
 * public interface Callable<V>
 * V call() throws Exception
 *
 * public interface Supplier<T>
 * T get();
 *
 * With an explicit cast,
 * the lambda expression is no longer ambiguous
 * and the compiler can handle it without issue.
 */
class CallableVsSupplier {

    static void useCallable(Callable<Integer> expression) {
    }

    static void useSupplier(Supplier<Integer> supplier) {
    }

    static void use(Callable<Integer> callable) {
    }

    static void use(Supplier<Integer> supplier) {
    }

    static void m() {
        useCallable(() -> {
            throw new IOException();
        });

        useSupplier(() -> {
//            throw new IOException();
            return null;
        });

        /**
         * Compiler error: ambiguity
         */
//        use(()->{
//           throw new RuntimeException();
//        });

        //again ambiguity
//        use(()->{
//            return 1;
//        });

        /**
         * Solution
         */
        use((Callable<Integer>) () -> {
            return 1;
        });

        use((Supplier<Integer>) () -> 1);

        /*
        Compiler error
         */
//        use((Callable<Integer>)()-> throw new IOException());


        use((Callable<Integer>) () -> {
            throw new RuntimeException();
        });

        use((Supplier<Integer>) () -> {
            throw new RuntimeException();
        });
    }
}


