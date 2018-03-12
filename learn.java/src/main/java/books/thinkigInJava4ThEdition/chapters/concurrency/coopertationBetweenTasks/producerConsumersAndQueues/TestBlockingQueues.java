package books.thinkigInJava4ThEdition.chapters.concurrency.coopertationBetweenTasks.producerConsumersAndQueues;

import books.thinkigInJava4ThEdition.chapters.concurrency.baiscThreading.definingTasks.LiftOff;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

class TestBlockingQueues {

    static void getKey(){
        try{
            new BufferedReader(new InputStreamReader(System.in)).readLine();
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    static void getKey(String message){
        System.out.println(message);
        getKey();
    }

    static void test(String msg, BlockingQueue<LiftOff> queue){
        System.out.println(msg);
        LiftOffRunner runner = new LiftOffRunner(queue);
        Thread t = new Thread(runner);
        t.start();
        for(int i = 0; i<5; i++){
            runner.put(new LiftOff(5));
        }
        getKey("Press 'Enter ' (" + msg + ")");
        t.interrupt();
        System.out.println("Finished " + msg + " test");
    }

    static void ex_28(String msg, BlockingQueue<LiftOff> queue){
        System.out.println(msg);
        LiftOffRunner runner = new LiftOffRunner(queue);
        Thread t = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i<5; i++){
                    runner.put(new LiftOff(5));
                }
            }
        };

        Thread m = new Thread(runner);
        m.start();
        t.start();
        getKey("Press 'Enter ' (" + msg + ")");
        m.interrupt();
        t.interrupt();
        System.out.println("Finished " + msg + " test");
    }


    public static void main(String[] args) {
//        m();
        m2();
    }


    private static void m2(){
        linkedBlockingQueue();
        arrayBlockingQueue();
        synchronousQueue();
    }

    private static void m() {
        linkedBlockingQueue();
        arrayBlockingQueue();
        synchronousQueue();
    }

    private static void synchronousQueue() {
        test("SynchronousQueue", new SynchronousQueue<LiftOff>());
    }

    private static void arrayBlockingQueue() {
        test("ArrayBlockingQueue", new ArrayBlockingQueue<LiftOff>(5));
    }

    private static void linkedBlockingQueue() {
        test("LinkedBlockingQueue", new LinkedBlockingQueue<LiftOff>());
    }

}

