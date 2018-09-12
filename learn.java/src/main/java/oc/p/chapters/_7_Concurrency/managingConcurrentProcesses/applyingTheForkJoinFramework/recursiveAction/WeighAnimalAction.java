package oc.p.chapters._7_Concurrency.managingConcurrentProcesses.applyingTheForkJoinFramework.recursiveAction;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

class WeighAnimalAction extends RecursiveAction{
    private int start;
    private int end;
    private Double[] weights;

    WeighAnimalAction(final Double[] weights, final int start, final int end) {
        this.start = start;
        this.end = end;
        this.weights = weights;
    }

    @Override
    protected void compute() {
        if(end-start <=3){
            for(int i=start; i<end; i++){
                weights[i] = new Random().nextDouble();
            }
        }else{
            int middle = start + ((end-start)/2);
            System.out.println("start: " + start);
            System.out.println("middle: " + middle);
            System.out.println("end: " + end);
            invokeAll(new WeighAnimalAction(weights, start, middle), new WeighAnimalAction(weights, middle, end));
        }
    }

    static void m(){
        Double[] weights = new Double[10];

        ForkJoinTask<?> task= new WeighAnimalAction(weights, 0, weights.length);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(task);

        Arrays.asList(weights).forEach(System.out::println);
    }

    public static void main(String[] args) {
        m();
    }
}
