package oc.p.chapters._7_Concurrency.managingConcurrentProcesses.applyingTheForkJoinFramework.tw._4;

import utils.print.Print;

import java.util.Map;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toMap;

class RecursiveAction_ extends RecursiveAction {

    private ConcurrentMap <Integer, Double> map;
    private int start;
    private int end;

    RecursiveAction_(final ConcurrentMap <Integer, Double> map, final int start, final int end) {
        this.map = map;
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if ((end - start) <= 10) {
            Map <Integer, Double> doubleMap = IntStream.range(start, end)
                    .mapToObj(i -> i)
                    .collect(toMap(Function.identity(), Integer::doubleValue));
            doubleMap.forEach((k, v) -> map.merge(k, v, (o, n) -> o.doubleValue() + n.doubleValue()));
        }else{
            int middle = start + (end-start)/2;
            invokeAll(new RecursiveAction_(map, start, middle), new RecursiveAction_(map, middle, end));
        }
    }

    public static void main(String[] args) {
        ConcurrentHashMap <Integer, Double> map = new ConcurrentHashMap <>();
        ForkJoinTask<?> task = new RecursiveAction_(map, 0, 10000);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(task);

        Print.print(map);
    }
}
