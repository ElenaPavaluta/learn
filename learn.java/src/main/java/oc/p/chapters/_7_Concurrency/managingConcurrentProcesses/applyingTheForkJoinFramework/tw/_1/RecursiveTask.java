package oc.p.chapters._7_Concurrency.managingConcurrentProcesses.applyingTheForkJoinFramework.tw._1;

import utils.javaClass.hierrarchy.methods.alphabet.F;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

class RecursiveTask extends java.util.concurrent.RecursiveTask<Integer> {

    private int nb;

    RecursiveTask(final int nb) {
        this.nb = nb;
    }

    @Override
    protected Integer compute() {
        if(nb <=1){
            return nb;
        }else{
            return nb * new RecursiveTask(nb-1).compute();
        }
    }

    static void m(){
        ForkJoinTask<Integer> task = new RecursiveTask(5);
        ForkJoinPool pool = new ForkJoinPool();
        Integer f = pool.invoke(task);
        System.out.println(f);
    }

    public static void main(String[] args) {
        m();
    }
}
