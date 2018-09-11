package oc.p.chapters._7_Concurrency.workingWithParallelStreams.processingTasksInParallel.avoidingStatefullOperations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Parallel {

    /**
     * The forEachOrdered() method displays the numbers in the stream sequentially,
     * whereas the order of the elements in the data list is completely random.
     * You can see that a stateful lambda expression, which modifies the data list
     * in parallel, produces unpredictable results at runtime.
     */
    static void m(){
        List<Integer> data = Collections.synchronizedList(new ArrayList<>());

        Arrays.asList(1, 2,3,4, 5, 6).parallelStream()
                .map(i->{
                    data.add(i);  //AVOID STATEFUL LAMBDA EXPRESSIONS!
                    return i;
                })
                .forEachOrdered(i-> System.out.print(i + " "));
        System.out.println();
        data.forEach(i->System.out.print(i + " "));
    }


    public static void main(String[] args) {
        m();
    }
}
