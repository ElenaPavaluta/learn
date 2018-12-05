package oc.p.chapters._10_.obtainingAStatement.choosingAResultSet.w_1;


import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

class Combination {

    List <Pair <Integer>> combs(int end) {
        ExecutorService exec = Executors.newCachedThreadPool();
        final List <Pair <Integer>> pairs = IntStream.rangeClosed(0, end)
                .mapToObj(i -> exec.submit(new UnitaryComb(i, end)))
                .map(f -> {
                    try {
                        return f.get(500, TimeUnit.MILLISECONDS);
                    } catch (InterruptedException | ExecutionException | TimeoutException e) {
                        e.printStackTrace();
                    }
                    return null;
                })
                .flatMap(List::stream)
                .collect(toList());
        exec.shutdown();
        try {
            exec.awaitTermination(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return pairs;
    }

    class UnitaryComb implements Callable <List <Pair <Integer>>> {

        private int start;
        private int end;

        UnitaryComb(final int start, final int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public List <Pair <Integer>> call() throws Exception {
            return IntStream.rangeClosed(0, end)
                    .mapToObj(i -> new Pair <>(start, i))
                    .collect(toList());
        }
    }

}
