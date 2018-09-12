package oc.p.chapters._7_Concurrency.managingConcurrentProcesses.applyingTheForkJoinFramework.tw._1;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.IntStream;

class RecursiveAction extends java.util.concurrent.RecursiveAction{

    private int start;
    private int end;
    int [] array;

    RecursiveAction(final int start, final int end, final int[] array) {
        this.start = start;
        this.end = end;
        this.array = array;
    }

    @Override
    protected void compute() {
        if(end-start <= 3){
            for(int i = start; i<end; i++){
                array[i] = i *i *i;
            }
        }else{
            int third = (end - start)/3;
            int firstThird = start + third;
            int secondThird = firstThird + third;
            invokeAll(new RecursiveAction(start, firstThird, array), new RecursiveAction(firstThird, secondThird, array), new RecursiveAction(secondThird, end, array));
        }
    }

    static void m(){
        int[] array = IntStream.range(0, 100).toArray();
        System.out.println(Arrays.toString(array));

        ForkJoinTask<?> task = new RecursiveAction(0, array.length, array);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(task);
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        m();
    }
}
