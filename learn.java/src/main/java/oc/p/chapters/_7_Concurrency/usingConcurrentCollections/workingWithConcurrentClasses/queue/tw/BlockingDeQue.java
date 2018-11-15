package oc.p.chapters._7_Concurrency.usingConcurrentCollections.workingWithConcurrentClasses.queue.tw;

import utils.print.Print;

import java.util.concurrent.*;

class BlockingDeQue {

    /**
     * ->Deque
     * ->BlockingQueue
     */
    BlockingDeque<Integer> bdq = new LinkedBlockingDeque<>();
    Runnable offerFirst = () -> {
        try {
            offerFirst();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    };

    Runnable offerLast = () -> {
        try {
            offerlast();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    };

    Runnable pollFirst = () -> {
        try {
            pollFirst();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    };

    Runnable pollLast = ()->{
        try {
            pollLast();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    };

    {
        bdq.offer(1);
        bdq.offer(2);
        bdq.offer(3);
    }

    void print(){
        Print.print("bdq", bdq);
    }

    void m(){
        ScheduledExecutorService ses = null;
        try{
            ses = Executors.newScheduledThreadPool(4);
            ses.scheduleAtFixedRate(offerFirst, 0, 200, TimeUnit.MILLISECONDS);
            ses.scheduleAtFixedRate(offerLast, 0, 250, TimeUnit.MILLISECONDS);
            ses.scheduleAtFixedRate(pollFirst, 0, 300, TimeUnit.MILLISECONDS);
            ses.scheduleAtFixedRate(pollLast, 0, 350, TimeUnit.MILLISECONDS);
            TimeUnit.SECONDS.sleep(3);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(ses !=null){
                ses.shutdownNow().forEach(System.out::println);
            }
        }

    }

    void offerFirst() throws InterruptedException {
        bdq.offerFirst(4, 250, TimeUnit.MILLISECONDS);
        print();
    }

    void offerlast() throws InterruptedException {
        bdq.offerLast(5, 300, TimeUnit.MILLISECONDS);
        print();
    }

    void pollFirst() throws InterruptedException {
        System.out.println(bdq.pollFirst(200, TimeUnit.MILLISECONDS));
    }

    void pollLast() throws InterruptedException {
        System.out.println(bdq.pollLast(250, TimeUnit.MILLISECONDS));
    }

    public static void main(String[] args) {
        BlockingDeQue q = new BlockingDeQue();

//        interview.print();
        q.m();
    }
}
