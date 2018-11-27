package oc.p.tests.chapters._20.q._19;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Riddle {

    void sleep(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
    }

    String getQuestion(Riddle r){
        synchronized (this){
            sleep();
            if(r != null) r.getAnswer(null);
            return "How many programmers does it take to change a light bulb";
        }
    }

    synchronized String getAnswer(Riddle r){
        sleep();
        if(r != null) r.getAnswer(null);
        return "None, that's a hardware problem";
    }

    public static void main(String[] args) {
        Riddle r = new Riddle();
        Riddle r2 = new Riddle();
        ExecutorService exec = Executors.newFixedThreadPool(2);
        exec.submit(()->r.getQuestion(r2));
        exec.submit(()->r2.getAnswer(r));
        exec.shutdown();
    }
}
