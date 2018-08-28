package oc.p.chapters._7_Concurrency.synchronizeDataAccess;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class SheepManager {

    private int sheepCount = 0;
    private void incrementAndReport(){
        System.out.print((++sheepCount) + " ");
    }

    static void m(){
        ExecutorService exec = null;
        try{
            exec = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors() * 10);
            SheepManager manager = new SheepManager();
            for (int i = 0; i< 10; i++){
                exec.submit(()->manager.incrementAndReport());
            }
        }finally {
            if(exec !=null){
                exec.shutdown();
            }
        }
    }

    public static void main(String[] args) {
        m();
    }

}
