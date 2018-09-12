package oc.p.chapters._7_Concurrency.managingConcurrentProcesses.applyingTheForkJoinFramework.tw._2;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.stream.IntStream;

class RA extends RecursiveAction
{

    int start, end;

    RA(final int start, final int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if((end - start)<=4){
            IntStream.range(start, end).filter(i->i%37==0).forEach(System.out::println);
        }else{
            int quarter = (end-start)/4;
            final int fq = this.start + quarter;
            final int sq = fq + quarter;
            final int tq = sq + quarter;
            invokeAll(new RA(this.start, fq), new RA(fq, sq), new RA(sq, tq), new RA(tq, end));
        }
    }

    static void m(){
        ForkJoinTask<?> task = new RA(0, 10000);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(task);
    }

    public static void main(String[] args) {
        m();
    }
}
