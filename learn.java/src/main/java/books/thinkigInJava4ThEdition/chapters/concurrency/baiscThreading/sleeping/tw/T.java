package books.thinkigInJava4ThEdition.chapters.concurrency.baiscThreading.sleeping.tw;

import java.util.concurrent.TimeUnit;

class T {

    static {
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getId());
    }

    public static void main(String[] args) throws
            InterruptedException {
//        m();
        m2();
    }

    static void m2() {
        class IT implements Runnable {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                System.out.println(Thread.currentThread().getId());
                try {
//                    TimeUnit.SECONDS.sleep(5);
//                    Thread.sleep(5000);
                    Thread.currentThread().sleep(5000);
                    System.out.println("IT sleep");
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        new Thread(new IT()).start();
    }

    private static void m() throws InterruptedException {
        //        Thread.sleep(10000);
        Thread.currentThread().sleep(10000);
//        TimeUnit.SECONDS.sleep(5);

    }
}
