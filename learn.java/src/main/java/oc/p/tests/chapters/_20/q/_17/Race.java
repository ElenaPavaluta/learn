package oc.p.tests.chapters._20.q._17;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

class Race {

    static ExecutorService exec = Executors.newFixedThreadPool(8);

    static int sleep(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {

        }
        return 1;
    }

    static void hare(){
        try {
            Callable c = ()->sleep();
            final Collection<Callable<Integer>> cc = Arrays.asList(c, c, c);
            List<Future<Integer>> r = exec.invokeAll(cc);
            System.out.println("Hare won the race");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    static void tortoise(){
        try {
            Callable c = () ->sleep();
            final Collection<Callable<Integer>> cc = Arrays.asList(c, c, c);
            Integer res = exec.invokeAny(cc);
            System.out.println("Tortoise won the race");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
       exec.execute(()->hare());
       exec.execute(()-> tortoise());
    }
}
