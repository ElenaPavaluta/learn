package books.thinkigInJava._4ThEdition.chapters.concurrency.baiscThreading.yielding;

/**
 *
 * Thread.yield:  merelly a hint that other threads of the same priority might be run.
 *
 */
class Yield {

    class A extends Thread{

        @Override
        public void run() {
            System.out.println("A run: " + Thread.currentThread().getId());
            Thread.currentThread().yield();
            System.out.println("A after yield");
        }
    }

    class B extends Thread{
        @Override
        public void run() {
            System.out.println("B run: " + Thread.currentThread().getId());
            System.out.println("B complete");
        }
    }

    static void m(){
        Yield y = new Yield();
        System.out.println("m: " + Thread.currentThread().getId());
        y. new A().start();
        y.new B().start();
    }

    static void m2(){
        Yield y = new Yield();
        System.out.println("m: " + Thread.currentThread().getId());
        y.new A().run();
        y.new B().run();
    }

    public static void main(String[] args) {
        m();
        //run in the same thread
//        m2();
    }
}
