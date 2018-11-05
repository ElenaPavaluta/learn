package oc.p.chapters._7_Concurrency.creatingThreadsWithExecutorService.submittingTasks.tw._2;

import java.util.concurrent.TimeUnit;

class R implements Runnable {

    @Override
    public void run() {
        try {
            TimeUnit.HOURS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
