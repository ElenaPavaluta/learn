package oc.p.chapters._7_Concurrency.managingConcurrentProcesses.applyingTheForkJoinFramework.recursiveTask;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

class WeighAnimalTask extends RecursiveTask<Double>{

    private int start;
    private int end;
    private Double[] weights;

    WeighAnimalTask(final int start, final int end, final Double[] weights) {
        this.start = start;
        this.end = end;
        this.weights = weights;
    }

    @Override
    protected Double compute() {
        double sum = 0;
        if(end-start<3){
           for(int i =start; i<end; i++){
               weights[i] = new Random().nextDouble();
               sum +=weights[i];
           }
            return sum;
        }else {
            int middle = start + (end-start)/2;
            System.out.println("[start="+start+",middle="+middle+",end="+end+"]");
            RecursiveTask<Double> rt = new WeighAnimalTask(start, middle, weights);
            rt.fork();
            return new WeighAnimalTask(middle, end, weights).compute() + rt.join();
        }
    }

    static void m(){
        Double[] weights = new Double[10];
        ForkJoinTask<Double> task = new WeighAnimalTask(0, weights.length, weights);
        ForkJoinPool pool = new ForkJoinPool();
        Double sum = pool.invoke(task);
        System.out.println("sum: " + sum);
    }

    public static void main(String[] args) {
        m();
    }
}
