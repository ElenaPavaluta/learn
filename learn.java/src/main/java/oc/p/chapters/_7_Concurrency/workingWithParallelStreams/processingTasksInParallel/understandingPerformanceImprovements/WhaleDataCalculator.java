package oc.p.chapters._7_Concurrency.workingWithParallelStreams.processingTasksInParallel.understandingPerformanceImprovements;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class WhaleDataCalculator {

    static int processRecordOld(int input){
        try {
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return input +1;
    }

    static void processAllDataOld(List<Integer> data){
        data.stream().map(WhaleDataCalculator::processRecordOld).count();
    }


    static void processAllDataNew(List<Integer> data){
        data.parallelStream().map(WhaleDataCalculator::processRecordOld).count();
    }

    static List<Integer> list(){
        return IntStream.iterate(0, i -> i + 1)
                .limit(4000)
                .mapToObj(Integer::new)
                .collect(Collectors.toList());
    }

    static void mOld(){
        long start = System.currentTimeMillis();
        processAllDataOld(list());
        long end = System.currentTimeMillis();
        System.out.println((end-start)/1000);
    }

    static void mNew(){
        long start = System.currentTimeMillis();
        processAllDataNew(list());
        long end = System.currentTimeMillis();
        System.out.println((end-start)/1000);
    }

    public static void main(String[] args) {
        mOld();
        mNew();
    }
}
