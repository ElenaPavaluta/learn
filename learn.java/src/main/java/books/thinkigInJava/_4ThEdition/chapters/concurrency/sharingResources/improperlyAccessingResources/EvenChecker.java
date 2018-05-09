package books.thinkigInJava._4ThEdition.chapters.concurrency.sharingResources.improperlyAccessingResources;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class EvenChecker implements Runnable {

    final int id;
    IntGenerator generator;

    public EvenChecker(IntGenerator generator, int id) {
        this.generator = generator;
        this.id = id;
    }

    static void test(IntGenerator gp, int count) {
        System.out.println("Ctrl + c to exit");
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < count; i++) {
            exec.execute(new EvenChecker(gp, count));
        }
        exec.shutdown();
    }

    static void m() {
        test(new ActualIntGenerator(), 10);
    }

    static void m2(){
        test(new EvenGenerator(), 10);
    }

    static void m3(){
        test(new SynchronizedEvenGenerator(), 10);
    }

    static void m4(){
        abort();
        test(new MutexEvenGenerator(), 10);
    }

    static void m5(){
        abort();
        test(new AtomicEvenGenerator(), 10);
    }

    private static void abort() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.err.println("Aborting");
                System.exit(0);
            }
        }, 3000);
    }

    public static void main(String[] args) {
//        m();
//        m2();
//        m3();
//        m4();
        m5();
    }

    @Override
    public void run() {
        while(!generator.isCanceled()) {
            int val = generator.next();
            if(val % 2 != 0) {
                System.out.println("val: " + val + " not even!");
                generator.cancel(); //cancels all Even checkers
            }
        }
    }
}
