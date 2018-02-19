package books.thinkigInJava4ThEdition.chapters.concurrency.sharingResources.improperlyAccessingResources;

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
        test(new MutexEvenGenerator(), 10);
    }

    public static void main(String[] args) {
//        m();
//        m2();
//        m3();
        m4();
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
